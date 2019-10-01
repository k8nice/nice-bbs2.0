package com.nice.commons.aes;


import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 * @author nice
 */
public class ActivateUtils {


    /**
     * 创建jwt加密token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
        //指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建payload的私有声明
        Map<String, Object> claims = new HashMap<String,Object>();
        // 自己修改
        claims.put("uid", "uid");
        // 自己修改
        claims.put("username", "username");
        // 自己修改
        claims.put("nickname", "nickname");

        //生成签名的时候使用的秘钥secret
        SecretKey key = generalKey();

        //添加各种标准声明和私有声明
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(id)
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串(也可以只存放一个id)，可以存放什么userid，作为什么用户的唯一标志。
                .setSubject(subject)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }


    /**
     * 解密jwt
     * 如果JWT以任何方式被篡改，则解析这些声明将会抛出一个SignatureException
     */
//    @SuppressWarnings("all")
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey key = generalKey();  //签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser()  //得到DefaultJwtParser
                .setSigningKey(key)  //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置需要解析的jwt

        return claims;
    }

    /**
     * 生成签名的时候使用的秘钥secret
     */
    private static SecretKey generalKey() {
        String stringKey = Constant.JWT_SECRET;//本地配置文件中加密的密文
        byte[] encodedKey = Base64.decodeBase64(stringKey);//本地的密码解码

        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }



    /**
     * 从token中获取用户id
     */
    public static Long getID(String token) throws Exception {

        return Long.parseLong(ActivateUtils.parseJWT(token).getSubject().replace("\"", ""));
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        String subject = JSON.toJSONString("1");
        try {
            String token = ActivateUtils.createJWT("jwt", subject, 28800000);
            //加密后的字段
            System.out.println(token);
            Claims c = ActivateUtils.parseJWT(token);
            //街舞t
            System.out.println(c.getId());
            System.out.println(c.getIssuedAt());
            //加密的字段：{id:100, name:joy}
            System.out.println(c.getSubject());
            System.out.println(c.get("uid", String.class));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("jwt已经过期");
        }
    }


}






