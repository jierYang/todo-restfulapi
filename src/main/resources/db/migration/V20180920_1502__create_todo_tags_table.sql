CREATE TABLE todo_tags(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tagsid INT,
  todoid INT,
  FOREIGN KEY (tagsid) REFERENCES tags(id),
  FOREIGN KEY (todoid) REFERENCES todo(id)
)engine=InnoDB DEFAULT CHARSET=gbk;