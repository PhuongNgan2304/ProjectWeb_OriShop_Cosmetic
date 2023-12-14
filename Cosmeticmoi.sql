CREATE DATABASE Cosmetic
GO

USE Cosmetic
GO

--LỨU Ý: MỚI TẠO LẠI DATABASE, CHỈ MỚI KÍCH HOẠT TABLE PRODUCT TYPES Và 2 DÒNG DỮ LIỆU TRONG ĐÓ CÒN LẠI THÌ CHƯA

------------------------------------Hàng hóa------------------------------------
/*Bổ sung thêm bảng Skins*/
CREATE TABLE Skins
(
	SkinID int identity(1,1) PRIMARY KEY,
	SkinName varchar(2000),
	Images varchar(2000)
)
GO


CREATE TABLE Product_Types
(
	TypeID int identity(1,1) PRIMARY KEY,
	TypeName nvarchar(2000),
	Images varchar(2000),
	TypeCode nvarchar(100),
	Status bit,

)
GO

CREATE TABLE Suppliers
(
	SupplierID int identity(1,1) PRIMARY KEY,
	SupplierName nvarchar(2000),
	Country nvarchar(2000),
	Images nvarchar(2000),
	Status bit
)
GO

CREATE TABLE Products
(
	ProductID int identity(1,1) PRIMARY KEY,
	ProductName nvarchar(2000),
	TypeID int,
	SupplierID int,
	SkinID int,
	Price int,
	Amount int,
	Description nvarchar(2000),
	Images varchar(2000),
	Status bit
)
GO

CREATE TABLE Cart
(
	CartID int identity (1,1) PRIMARY KEY,
	UserID int, 
	CartCode varchar (100)
)

--ALTER TABLE Cart DROP COLUMN Active--'

CREATE TABLE Cart_Product
(
	id int identity(1,1) PRIMARY KEY,
	CartID int,
	ProductID int,
	quantity int,
	totalPrice int
)

select * from Cart_Product
CREATE TABLE Order_User
(
	OrderID int identity (1,1) PRIMARY KEY,
	CartID int,
	Paid bit,
	Total int,
	Adress nvarchar(1000),
	OrderDate date,
	ArriveDate date
)


CREATE TABLE Users
(
	UserID int identity (1,1) PRIMARY KEY,
	Username nvarchar(50),
	Password nvarchar(50),
	Phone nvarchar(15),
	Fullname nvarchar(50),
	Email nvarchar(150),
	Admin bit,
	Active bit,
	Images nvarchar(1000)
)
GO

-------------------------------Thêm thuộc tính Bảng Products-----------------------------------
/*ALTER TABLE Products ADD SkinID int;
ALTER TABLE Products ADD Amount int;*/

/*ALTER TABLE Cart ADD Active bit*/
select * from Cart
select * from Cart_Product

-------------------------------Thêm khóa ngoại cho bảng Products-----------------------------------
ALTER TABLE Products ADD CONSTRAINT FK_typeid FOREIGN KEY (TypeID) REFERENCES Product_Types (TypeID)
ALTER TABLE Products ADD CONSTRAINT FK_supplierid FOREIGN KEY (SupplierID) REFERENCES Suppliers (SupplierID)
ALTER TABLE Products ADD CONSTRAINT FK_skinid FOREIGN KEY (SkinID) REFERENCES Skins (SkinID)

-------------------------------Thêm khóa ngoại cho bảng Cart và Cart_Product-----------------------------------
ALTER TABLE Cart_Product ADD CONSTRAINT FK_cartid FOREIGN KEY (CartID) REFERENCES Cart (CartID)
ALTER TABLE Cart_Product ADD CONSTRAINT FK_pid FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
ALTER TABLE Cart ADD CONSTRAINT FK_uid FOREIGN KEY (UserID) REFERENCES Users (UserID)

ALTER TABLE Order_User ADD CONSTRAINT FK_ordercartid FOREIGN KEY (CartID) REFERENCES Cart (CartID)


/*ALTER TABLE Cart_Product drop constraint FK_cartid
ALTER TABLE Cart_Product drop constraint FK_pid*/

-------------------------------Thêm nội dung cho phần Hàng hóa-----------------------------------
/*INSERT INTO Product_Types(TypeID, TypeName, Images) VALUES (1, 'Micellar water', 'https://seun.vn/media/news/110-review-nuoc-tay-trang-2022.jpg')
INSERT INTO Product_Types(TypeID, TypeName, Images) VALUES (2, 'Cleanser', 'https://product.hstatic.net/1000379579/product/z3656247159730_73681af97b12936f1229000ebb70eb30_cb520facb3aa4fd0a296ca8aadbff51e_master.jpg')
INSERT INTO Product_Types(TypeID, TypeName, Images) VALUES (3, 'Toner', 'https://img.makeupalley.com/1/1/8/1/3581130.JPG')
INSERT INTO Product_Types(TypeID, TypeName, Images) VALUES (4, 'Serum', 'https://product.hstatic.net/1000360941/product/serum-rau-ma-skin1004_d426b5a03c224f2aaf53ec8981207068_master.jpg')
INSERT INTO Product_Types(TypeID, TypeName, Images) VALUES (5, 'Moisturizing cream', 'https://cdn.tgdd.vn/Files/2021/02/19/1328668/top-10-kem-duong-da-ban-dem-tot-nhat-ban-khong-the-bo-qua-202202151150463439.jpg')*/

INSERT INTO Product_Types(TypeName, Images, TypeCode, Status) VALUES ('Micellar water', 'taytrang.jpg', 'Code01', 1)
INSERT INTO Product_Types(TypeName, Images, TypeCode, Status) VALUES ('Cleanser', 'cleanser.jpg', 'Code02', 1)



/*INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (1, 'Simple', 'USA')
INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (2, 'Garnier', 'USA')
INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (3, 'Loreal', 'USA')
INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (4, 'Bioderma', 'USA')
INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (5, 'The face shop', 'USA')
INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (6, 'CeraVe', 'USA')
INSERT INTO Suppliers(SupplierID, SupplierName, SupplierAdress) VALUES (7, 'Klairs', 'USA')*/


INSERT INTO Suppliers(SupplierName, Country, Images, Status) VALUES ('Simple', 'United Kingdom', 'simple.png', 1)
INSERT INTO Suppliers(SupplierName, Country, Images, Status) VALUES ('Biodrema', 'France', 'Bioderma.png', 1)
INSERT INTO Suppliers(SupplierName, Country, Images, Status) VALUES ('The Face Shop', 'Korea', 'thefaceshop.png', 1)


/*INSERT INTO Skins(SkinID, SkinName) VALUES (1, 'Normal skin')
INSERT INTO Skins(SkinID, SkinName) VALUES (2, 'Dry skin')
INSERT INTO Skins(SkinID, SkinName) VALUES (3, 'Oily skin ')
INSERT INTO Skins(SkinID, SkinName) VALUES (4, 'Sensitive skin')
INSERT INTO Skins(SkinID, SkinName) VALUES (5, 'Acne skin')*/

INSERT INTO Skins(SkinName, Images) VALUES ('Normal skin', 'dathuong.jpg')



/*INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES (1, 'Simple Micellar Water', 1, 1, 100000, 'Micellar water for sensitive skin', 'https://www.simpleskincare.com/sk-eu/content/dam/brands/simple/global_use/1880149-simple-kts-micellar-water-200ml-v3-recycled.jpg', 4, 100)
INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES (2, 'Garnier Micellar Cleansing Water', 1, 2, 120000, 'Micellar water for all kinds of skin', 'https://www.garnierusa.com/-/media/project/loreal/brand-sites/garnier/usa/us/pdp_images/skincare/micellar-water-new-packshots/hyalu-acid/new/garnier_micellar_hyaluronicacid_frontpack_allurebadge-png.png?rev=4369f1e2c54c4d1c821db90762880dd9&hash=3D9D74E2445FD94577C2CAA85A0ADDBB', 1, 210)
INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES (3, 'CeraVe Foaming Cleanser', 2, 6, 130000, 'Gel cleanser for normal to oily skin', 'https://product.hstatic.net/1000025647/product/cerave-foaming-cleanser-for-normal-_9a830e914a2f4f7a86cf7038d7668e6c_master.png', 3, 150)
INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES (4, 'Klairs Toner', 3, 7, 140000, 'Moisturizing toner for sensitive skin', 'https://product.hstatic.net/1000006063/product/vn-11134201-23020-nlxu8ypf6tnvbd_280502e9615e4c9b9b9ea2e2acedbcc2_1024x1024.jpg', 4, 140)
INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES(5, 'Simple Purifying Gel Wash', 2, 1, 135000, 'Gel Wash Deeply Cleanses For Controlled Shine And Clear Skin', 'https://data-service.pharmacity.io/pmc-upload-media/production/pmc-ecm-core/products/P22494_20.jpg', 5, 100)

INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES(6, 'Bioderma Sensibio Tonique', 3, 4, 120000, 'Toner helps moisturizes and soothes the skin, enhancing skin care effectiveness', 'https://th.bing.com/th/id/R.33a9e16a66232772ebc52fb9ae33ae8a?rik=SPCPRFy8AVnWig&pid=ImgRaw&r=0', 4, 200)
INSERT INTO Products(ProductID, ProductName, TypeID, SupplierID, ProductPrice, Product_Description, ProductImageURL, SkinID, Amount)
VALUES(7, 'The Face Shop Vitamin C Brightening Serum', 4, 5, 899000, 'Serum removes brown spots, fade freckles, and dark spots on the skin by up tp 98%, bringing radiant skin full of vitality', 'https://image.hsv-tech.io/0x1387/tfs/common/f456b3c5-e748-44d0-a108-7235e6055fa5.webp',1, 90)*/

INSERT INTO Products(ProductName, TypeID, SupplierID, SkinID, Price, Amount, Description, Images, Status)
VALUES ('Simple Micellar Water', 1, 1, 1, 100000, 200, 'Micellar water for sensitive skin', 'simple_micellar.png', 1)
INSERT INTO Products(ProductName, TypeID, SupplierID, SkinID, Price, Amount, Description, Images, Status)
VALUES ('Simple Purifying Gel Wash', 2, 1, 1, 100000, 200, 'Gel Wash Deeply Cleanses For Controlled Shine And Clear Skin', 'srm_simple_xanhduong.png', 1)


INSERT INTO Users (Username, Password, Phone, Fullname, Email, Admin, Active, Images) VALUES ('rose', '123456', '099999999', 'Rose Nguyen', 'rose.nguyen123@gmail.com', 0,  1, null)
INSERT INTO Users (Username, Password, Phone, Fullname, Email, Admin, Active, Images) VALUES ('abc', '123456', '099999999', 'ABC', 'rose.nguyen123@gmail.com', 1,  1, null)


/*Simple Soothing Eye Balm - Revitalize the tired skin around the eyes, such as wrinkles, dryness, and dark circles*/

/*delete products
select * from Products
select * from Skins*/
---ALTER TABLE Products DROP CONSTRAINT fk_supplierid;---
/*ALTER TABLE Products DROP CONSTRAINT FK_typeid;
ALTER TABLE Products DROP CONSTRAINT FK_supplierid;
ALTER TABLE Products DROP CONSTRAINT FK_skinid;*/

--delete Product_Types--


/*UPDATE Product_Types
SET TypeImageURL = 'https://img.makeupalley.com/1/1/8/1/3581130.JPG'
WHERE TypeID =3;*/

-------------------------------Thêm nội dung cho phần Giỏ hàng-----------------------------------
INSERT INTO Cart (UserID, CartCode) VALUES (2, 'Cart01')

INSERT INTO Cart_Product(CartID,ProductID, quantity, totalPrice) VALUES (2, 1, 1, 500000)
INSERT INTO Cart_Product(CartID, ProductID, quantity, totalPrice) VALUES (2, 1, 2, 200000)


select * from Product_Types
select * from Products
select * from Skins
select * from Suppliers

select * from Products
select top 3 * from Products

select * from Users
select * from Cart
select * from Cart_Product
select * from Order_User
select sum(totalPrice) from Cart_Product where CartID = 3

SELECT TOP 4* FROM Products ORDER BY Amount DESC

SELECT TOP 4* FROM Products ORDER BY ProductID DESC
SELECT TOP 1* FROM Products ORDER BY ProductID DESC

/*delete Products where ProductID = 7*/


/*delete Products
delete Product_Types
delete Suppliers
delete Skins


drop table Products
drop table Product_Types
drop table Suppliers
drop table Skins*/


SELECT TypeID, COUNT(*) AS num_products
FROM Products
GROUP BY TypeID

select * from Products
select * from Cart_Product
select * from Cart
select * from Users
select * from Order_User

CREATE TRIGGER trg_Cart_Product_Insert
ON Cart_Product
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @ProductID INT;
    DECLARE @Quantity INT;

    -- Lấy thông tin từ bảng Cart_Product vừa chèn
    SELECT @ProductID = i.ProductID, @Quantity = i.Quantity
    FROM inserted i;

    -- Giảm số lượng sản phẩm tương ứng trong bảng Products
    UPDATE Products
    SET Amount = Amount - @Quantity
    WHERE ProductID = @ProductID;
END;
