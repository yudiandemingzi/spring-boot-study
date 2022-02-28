

CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `pwd` varchar(128) DEFAULT NULL COMMENT '密码',
  `sex` int DEFAULT NULL COMMENT '性别',
  `img` varchar(128) DEFAULT NULL COMMENT '头像',
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `index_phone` (`phone`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `user` (`id`, `phone`, `pwd`, `sex`, `img`, `username`, `create_time`)
VALUES
	(1,'18812345678','123456',1,'www.touxiang.com','小小','2021-04-03 11:48:46'),
	(2,'18887654321','654321',2,'www.touxiang.com','张三','2021-04-03 11:48:46'),
	(5,'18812345678','123456',1,'www.touxiang.com','小小','2021-04-03 11:48:46');


