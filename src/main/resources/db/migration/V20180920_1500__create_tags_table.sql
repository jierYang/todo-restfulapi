CREATE TABLE tags(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (255),
  user_id INT ,
  FOREIGN KEY (user_id) REFERENCES user(id)
)engine=InnoDB DEFAULT CHARSET=gbk;