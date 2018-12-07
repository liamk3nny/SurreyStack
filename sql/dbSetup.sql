/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  liamkenny
 * Created: 06-Dec-2018
 */

SET SQL_SAFE_UPDATES = 0;

DELETE FROM `surreystack`.`comments`;
DELETE FROM `surreystack`.`posts`;
DELETE FROM `surreystack`.`tags`;
DELETE FROM `surreystack`.`users`;
DELETE FROM `surreystack`.`roles`;

INSERT INTO `surreystack`.`roles` (`role_id`,`rolename`) VALUES ('1','ROLE_ADMIN');
INSERT INTO `surreystack`.`roles` (`role_id`,`rolename`) VALUES ('2','ROLE_USER');

INSERT INTO `surreystack`.`users` (`user_id`, `fullName`, `password`, `username`, `role_id`) VALUES ('1', 'Liam Kenny', '123', 'lk00292', '1');
INSERT INTO `surreystack`.`users` (`user_id`, `fullName`, `password`, `username`, `role_id`) VALUES ('2', 'Ignas Kampas', '123', 'ik00157', '1');
INSERT INTO `surreystack`.`users` (`user_id`, `fullName`, `password`, `username`, `role_id`) VALUES ('3', 'Bogdan Vrusias', '123', 'bogo', '2');

INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('1', 'Accounting');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('2', 'Biology');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('3', 'Chemistry');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('4', 'Computer Science');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('5', 'Dance');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('6', 'English');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('7', 'Electronic Engineering');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('8', 'Film');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('9', 'Law');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('10', 'Maths');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('11', 'Nersing');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('12', 'Physics');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('13', 'Psychology');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('14', 'Sports');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('15', 'Theatre');
INSERT INTO `surreystack`.`tags` (`tag_id`, `name`) VALUES ('16', 'Veterinary');

INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('1', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '1', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('2', 'This is body 2', '2011-01-01 00:00:00', 'Title 2', '1', '2');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('3', 'This is body 3', '2011-01-01 00:00:00', 'Title 3', '1', '3');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('4', 'This is body 4', '2011-01-01 00:00:00', 'Title 4', '1', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('5', 'This is body 5', '2011-01-01 00:00:00', 'Title 5', '1', '2');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('6', 'This is body 6', '2011-01-01 00:00:00', 'Title 6', '1', '3');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('7', 'This is body 7', '2011-01-01 00:00:00', 'Title 7', '1', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('8', 'This is body 8', '2011-01-01 00:00:00', 'Title 8', '1', '2');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('9', 'This is body 9', '2011-01-01 00:00:00', 'Title 9', '1', '3');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('10', 'This is body 10', '2011-01-01 00:00:00', 'Title 10', '1', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('11', 'This is body 11', '2011-01-01 00:00:00', 'Title 11', '1', '2');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('12', 'This is body 12', '2011-01-01 00:00:00', 'Title 12', '1', '3');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('13', 'This is body 13', '2011-01-01 00:00:00', 'Title 13', '1', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('14', 'This is body 14', '2011-01-01 00:00:00', 'Title 14', '1', '2');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('15', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '2', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('16', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '3', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('17', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '4', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('18', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '5', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('19', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '6', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('20', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '7', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('21', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '8', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('22', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '9', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('23', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '10', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('24', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '11', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('25', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '12', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('26', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '13', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('27', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '14', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('28', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '15', '1');
INSERT INTO `surreystack`.`posts` (`post_id`, `body`, `date`, `title`, `tag_id`, `user_id`) VALUES ('29', 'This is body 1', '2011-01-01 00:00:00', 'Title 1', '16', '1');

INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '1');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '2');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '3');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '1');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '2');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '3');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '1');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '2');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '3');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '1');
INSERT INTO `surreystack`.`comments` (`body`, `date`, `post_id`, `user_id`) VALUES ('Comment 1', '2011-01-01 00:00:00', '1', '2');
