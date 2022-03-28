import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/3/28 21:13
 * @description:
 */
public class JwtUtilsTest {
    //常量
    public static final long EXPIRE = 1000L * 60 * 60 * 24*365; //token过期时间

    public static final String APP_SECRET = "gvo7i93ULJGO0GZvKMhgZBTrBfDnrLp41n5"; //秘钥

    @Test
    public void test01() {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                .setSubject("light-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                .claim("id", 1)  //设置token主体部分 ，存储用户信息
                .claim("code", 1)

                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        System.out.println(JwtToken);

    }
}
