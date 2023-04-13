package com.anydoortrip.anydoortrip.apps.utlis;


public class Jwt {
//    /**
//     * 日志器
//     */
//    private static final Logger logger = LoggerFactory.getLogger(Jwt.class);
//
//    /**
//     * 使用Openssl生成的密钥
//     */
//    private static final String SECRET = "224119e04f236694d37c4f062f31175906fef1833af5cdd15b4300b5b797ddb215436f";
//
//    /**
//     * 过期时间
//     */
//    private static final long EXPIRATION = 604800L;//单位为秒
//
//    /**
//     * 生成用户token
//     *
//     * @param user 用户实现类对象
//     * @return jwt token 字符串
//     */
//    public static String createToken(User user) {
//        //过期时间
//        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
//        Map<String, Object> map = new HashMap<>();
//        map.put("alg", "HS256");
//        map.put("typ", "JWT");
//        return JWT.create()
//                .withHeader(map) // 设置头部
//                .withClaim("id", user.getId()) // 设置用户信息
//                .withExpiresAt(expireDate) //超时设置,设置过期的日期
//                .withIssuedAt(new Date()) //签发时间
//                .sign(Algorithm.HMAC256(SECRET));
//    }
//
//    /**
//     * 校验token并解析token
//     */
//    public static Map<String, Claim> verifyToken(String token) {
//        DecodedJWT jwt;
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//            jwt = verifier.verify(token);
//
//        } catch (JWTVerificationException e) {
//            logger.error(e.getMessage());
//            logger.error("jwt 验证失败");
//            //解码异常则抛出异常
//            return null;
//        }
//        return jwt.getClaims();
//    }
}
