CREATE TABLE todo_tags(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tags_id INT,
  todo_id INT,
  FOREIGN KEY (tags_id) REFERENCES tags(id),
  FOREIGN KEY (todo_id) REFERENCES todo(id)
)engine=InnoDB DEFAULT CHARSET=gbk;