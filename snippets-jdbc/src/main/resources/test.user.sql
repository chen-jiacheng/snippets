-- test.`USER` definition

CREATE TABLE `USER` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
    `password` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
    `address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
    `phone_number` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
    `email_address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱地址',
    `user_status` int NOT NULL DEFAULT '1' COMMENT '用户状态: 1.正常 2.冻结 3.已注销',
    `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';


INSERT INTO test.`USER`
(id, username, password, address, phone_number, email_address, user_status, create_at, update_at)
VALUES(1, 'Charlie Smith', '3B^s9$p!', 'USA', '+1-1234567890', 'charlie.smith@gmail.com', 1, '2024-01-26 00:40:02', '2024-01-26 00:40:02');
INSERT INTO test.`USER`
(id, username, password, address, phone_number, email_address, user_status, create_at, update_at)
VALUES(2, 'Alice Johnson', 'tL7aGp2*', 'USA', '+1-9876543210', 'alice.johnson@yahoo.com', 1, '2024-01-26 00:40:02', '2024-01-26 00:40:02');
INSERT INTO test.`USER`
(id, username, password, address, phone_number, email_address, user_status, create_at, update_at)
VALUES(3, 'Frank Davis', 'pP#8rS!e', 'USA', '+1-5551234567', 'frank.davis@hotmail.com', 1, '2024-01-26 00:40:02', '2024-01-26 00:40:02');
INSERT INTO test.`USER`
(id, username, password, address, phone_number, email_address, user_status, create_at, update_at)
VALUES(4, 'Emma Williams', '@W6sHxL$', 'USA', '+1-1112223333', 'emma.williams@example.com', 1, '2024-01-26 00:40:02', '2024-01-26 00:40:02');
INSERT INTO test.`USER`
(id, username, password, address, phone_number, email_address, user_status, create_at, update_at)
VALUES(5, 'Jack Taylor', 'zXv2*rP9', 'USA', '+1-4445556666', 'jack.taylor@gmail.com', 1, '2024-01-26 00:40:02', '2024-01-26 00:40:02');