CREATE TABLE if not exists RESTAURANT(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    cuisinetype VARCHAR(255),
    rating VARCHAR(255));

CREATE TABLE if not exists CHEF(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    expertise VARCHAR(255),
    experienceyears INT,
    restaurantid INT, FOREIGN KEY (restaurantid) REFERENCES CHEF(id));
