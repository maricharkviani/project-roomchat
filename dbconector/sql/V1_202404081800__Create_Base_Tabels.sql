CREATE TABLE `room_chat`.`room_chat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `max_members` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `room_chat`.`user_session` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `session_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`));
