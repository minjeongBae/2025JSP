## DESCRIBE POST
```
Field        | Type            Null    Key     Default        Extra
```          
POST_ID      | int             NO      PRI                    auto_increment
TITLE        | varchar(200)    NO
CATEGORY     | varchar(10)     YES
WRITER       | varchar(100)    NO
VIEWS        | int             NO                0
CREATE_DATE  | date            YES
UPDATE_DATE  | date            YES
CONTENT      | text            NO


## DESCRIBE POST
```
Field        | Type            Null    Key     Default        Extra
```
POST_ID      | int             NO      MUL
CID          | int             NO      PRI                    auto_increment
CONTENT      | varchar(300)    YES
WRITER       | varchar(100)    YES
CREATE_DATE  | date            YES
