use restaurant;

drop table if exists tbl_restaurant;
create table tbl_restaurant
(
    id          INT Primary Key AUTO_INCREMENT,
    name        VARCHAR(100),
    category    VARCHAR(100),
    address     VARCHAR(255),
    description TEXT
);

select *
from tbl_restaurant;

DROP TABLE IF EXISTS tbl_restaurant_review;

CREATE TABLE tbl_restaurant_review
(
    no            INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    writer        VARCHAR(100),
    content       TEXT,
    score         INT,
    FOREIGN KEY (restaurant_id) REFERENCES tbl_restaurant (id) ON DELETE CASCADE
);

select *
from tbl_restaurant_review;

select F.name, round(AVG(R.score), 2) as averageScore, F.address
from tbl_restaurant F
         left outer join tbl_restaurant_review R on F.id = R.restaurant_id
group by F.name, F.address
order by averageScore desc;