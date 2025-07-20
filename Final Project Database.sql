CREATE DATABASE CafeManagementSystem;
USE CafeManagementSystem;

-- 1
CREATE TABLE `User` (
    user_id CHAR(20) PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    nic CHAR(15) NOT NULL UNIQUE,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50) NOT NULL,
    email VARCHAR(254) NOT NULL UNIQUE,
    role VARCHAR(20) NOT NULL,
    password VARCHAR(70) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    salt_no INT NOT NULL
);

--  ALTER TABLE `User` DROP INDEX `nic`;
-- SHOW CREATE TABLE `User`;


 -- 2
CREATE TABLE User_contact (
    user_id CHAR(20) NOT NULL,
    tele VARCHAR(15) NOT NULL,
    PRIMARY KEY (user_id, tele),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- 3
CREATE TABLE Login (
    user_id CHAR(20) NOT NULL,
    logged_time TIME NOT NULL,
    logged_date DATE NOT NULL,
    PRIMARY KEY (user_id, logged_time),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);
-- 4
CREATE TABLE Log_sheet (
    sheet_id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(25) NOT NULL,
    made_date DATE NOT NULL,
    description TEXT,
    user_id CHAR(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- 5
CREATE TABLE Time_sheet (
    user_id CHAR(20) NOT NULL,
    date DATE NOT NULL,
    clockin_time TIME NOT NULL,
    clockoff_time TIME,
    PRIMARY KEY(user_id, date),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- 6
CREATE TABLE Report (
    user_id CHAR(20) NOT NULL,
    made_time TIME NOT NULL,
    date DATE NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY(user_id, made_time),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- 7
CREATE TABLE Notification (
    note_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id CHAR(20) NOT NULL,
    made_date DATE NOT NULL,
    description TEXT,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- 8


-- 9
CREATE TABLE Branch (
    branch_id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(100) NOT NULL,
    email VARCHAR(254) NOT NULL UNIQUE,
    Telephone VARCHAR(20) NOT NULL
);

-- 10

-- 11
CREATE TABLE Task (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT NOT NULL,
    due_date DATE,
    status VARCHAR(20),
    user_id CHAR(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- 12
CREATE TABLE Complaint (
    comp_id INT AUTO_INCREMENT PRIMARY KEY,
    made_date DATE NOT NULL,
    description TEXT,
    status VARCHAR(15)
);

-- 13
CREATE TABLE Product (
    product_id CHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    availability BOOLEAN DEFAULT FALSE
);

-- 14
CREATE TABLE Inventory_item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(15),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);

ALTER TABLE inventory_item ADD COLUMN unit VARCHAR(5);

-- 15
CREATE TABLE Item_product (
    product_id CHAR(20) NOT NULL,
    item_id INT NOT NULL,
    PRIMARY KEY(product_id, item_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES Inventory_item(item_id) ON DELETE CASCADE
);

-- 16
CREATE TABLE Supplier (
    supp_id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50),
    email VARCHAR(254) NOT NULL UNIQUE
);

CREATE TABLE Supplier_item(
	supp_id INT NOT NULL,
    item_id INT NOT NULL,
    PRIMARY KEY(supp_id, item_id),
    FOREIGN KEY (item_id) REFERENCES Inventory_item(item_id) ON DELETE CASCADE,
    FOREIGN KEY (supp_id) REFERENCES Supplier(supp_id) ON DELETE CASCADE
);

-- 17
CREATE TABLE Supplier_contact (
    supp_id INT NOT NULL,
    tele VARCHAR(15) NOT NULL,
    PRIMARY KEY (supp_id, tele),
    FOREIGN KEY (supp_id) REFERENCES Supplier(supp_id) ON DELETE CASCADE
);

-- 18
CREATE TABLE Request(
	req_id INT AUTO_INCREMENT PRIMARY KEY,
	made_date DATE NOT NULL,
    description TEXT,
    status VARCHAR(15),
    user_id CHAR(20),
    branch_id INT,
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE,
    FOREIGN KEY (branch_id) REFERENCES Branch(branch_id) ON DELETE CASCADE
);

-- 19
CREATE TABLE `Order`(
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    made_date DATE NOT NULL,
    made_time TIME NOT NULL,
    order_type VARCHAR(15) NOT NULL,
    status VARCHAR(20),
    amount DECIMAL(10, 2) NOT NULL,
    service_charge DECIMAL(10, 2),
    discount DECIMAL(5, 2),
    tax DECIMAL(5, 2),
    total DECIMAL(10, 2) NOT NULL,
    user_id CHAR(20),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

ALTER TABLE `Order` AUTO_INCREMENT = 1;

-- 20
CREATE TABLE Customer(
	cus_id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
	address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50) NOT NULL,
    tele VARCHAR(15) NOT NULL
);

-- 21
CREATE TABLE Bulk_order(
	order_id INT PRIMARY KEY,
    cus_id INT NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE,
    FOREIGN KEY (cus_id) REFERENCES Customer(cus_id) ON DELETE CASCADE
);

-- 22
-- KOT = KITCHEN ORDER TICKET
CREATE TABLE Kot(
	kot_id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(20),
    order_id INT NOT NULL,
    user_id CHAR(20),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE,
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE
);

CREATE TABLE Stock (
    stock_id INT AUTO_INCREMENT PRIMARY KEY,
    item_id INT NOT NULL,
    add_date DATE NOT NULL,
    add_time TIME NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (item_id) REFERENCES Inventory_item(item_id) ON DELETE CASCADE
);

-- 23
CREATE TABLE Stock_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    item_id INT NOT NULL,
    action VARCHAR(10) NOT NULL,
    change_date DATE NOT NULL,
    change_time TIME NOT NULL,
    old_quantity INT,
    new_quantity INT,
    FOREIGN KEY (item_id) REFERENCES Inventory_item(item_id) ON DELETE CASCADE
);


-- 24
CREATE TABLE Product_order(
	order_id INT NOT NULL,
    product_id CHAR(20) NOT NULL,
    PRIMARY KEY(order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE
);

-- 25
CREATE TABLE Expense (
	expense_id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    made_date DATE NOT NULL,
    made_time TIME NOT NULL,
    amount DECIMAL(10, 2)
);

-- 26
CREATE TABLE Supplier_Purchase (
    expense_id INT PRIMARY KEY,
    item_id INT NOT NULL,
    supplier_id INT NOT NULL,
    invoice_number VARCHAR(50) NOT NULL UNIQUE,
    discount DECIMAL(10, 2) DEFAULT 0 NOT NULL,
    FOREIGN KEY (expense_id) REFERENCES Expense(expense_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES Inventory_item(item_id) ON DELETE CASCADE,
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supp_id) ON DELETE CASCADE
);


-- 27
CREATE TABLE Salary (
    expense_id INT PRIMARY KEY,
    user_id CHAR(20) NOT NULL,
    bonus DECIMAL(10, 2) DEFAULT 0 NOT NULL,
    deductions DECIMAL(10, 2) DEFAULT 0 NOT NULL,
    FOREIGN KEY (expense_id) REFERENCES Expense(expense_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);
SELECT gross_salary + COALESCE(bonus, 0) - COALESCE(deductions, 0) AS net_salary FROM Salary;
-- 28
CREATE TABLE Expense_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    expense_id INT NOT NULL,
    action VARCHAR(10) NOT NULL,
    change_date DATE NOT NULL,
    change_time TIME NOT NULL,
    old_amount DECIMAL(10, 2),
    new_amount DECIMAL(10, 2),
    FOREIGN KEY (expense_id) REFERENCES Expense(expense_id) ON DELETE CASCADE
);




