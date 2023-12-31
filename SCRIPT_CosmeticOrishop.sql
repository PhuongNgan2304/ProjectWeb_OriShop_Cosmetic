USE [Cosmetic]
GO
/****** Object:  User [phuongngan]    Script Date: 12/15/2023 8:01:51 AM ******/
CREATE USER [phuongngan] FOR LOGIN [phuongngan] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[CartID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NULL,
	[CartCode] [varchar](100) NULL,
	[OrderID] [int] NULL,
	[Active] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[CartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart_Product]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart_Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[CartID] [int] NULL,
	[ProductID] [int] NULL,
	[quantity] [int] NULL,
	[totalPrice] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_User]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_User](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[CartID] [int] NULL,
	[Paid] [bit] NULL,
	[Total] [int] NULL,
	[Adress] [nvarchar](1000) NULL,
	[OrderDate] [date] NULL,
	[ArriveDate] [date] NULL,
	[cart] [varbinary](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_Types]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_Types](
	[TypeID] [int] IDENTITY(1,1) NOT NULL,
	[TypeName] [nvarchar](2000) NULL,
	[Images] [varchar](2000) NULL,
	[TypeCode] [nvarchar](100) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[TypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](2000) NULL,
	[TypeID] [int] NULL,
	[SupplierID] [int] NULL,
	[SkinID] [int] NULL,
	[Price] [int] NULL,
	[Amount] [int] NULL,
	[Description] [nvarchar](2000) NULL,
	[Images] [varchar](2000) NULL,
	[Status] [bit] NULL,
	[CartID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Skins]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skins](
	[SkinID] [int] IDENTITY(1,1) NOT NULL,
	[SkinName] [varchar](2000) NULL,
	[Images] [varchar](2000) NULL,
PRIMARY KEY CLUSTERED 
(
	[SkinID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[SupplierID] [int] IDENTITY(1,1) NOT NULL,
	[SupplierName] [nvarchar](2000) NULL,
	[Country] [nvarchar](2000) NULL,
	[Images] [nvarchar](2000) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[SupplierID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 12/15/2023 8:01:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Active] [bit] NULL,
	[Admin] [bit] NULL,
	[Email] [varchar](255) NULL,
	[Fullname] [varchar](255) NULL,
	[Images] [varchar](255) NULL,
	[Password] [varchar](255) NULL,
	[Phone] [varchar](255) NULL,
	[Username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Cart] ON 

INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (1, 2, N'Cart01', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (2, 1, N'Code0222', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (3, 1, N'code03', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (4, 1, N'aaaaa', NULL, 1)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (7, 1, N'123', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (8, NULL, NULL, NULL, 1)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (9, 1, N'CartNew', NULL, 1)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (11, 1, N'Cart999', NULL, 1)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (12, 5, N'Cart_Tri', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (13, 5, N'Cart_Tri_2', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (16, 4, N'Cart_ABC 123', NULL, 0)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (17, 4, N'Cart_NhiNgan', NULL, 1)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (18, 4, N'afdasfs', NULL, 1)
INSERT [dbo].[Cart] ([CartID], [UserID], [CartCode], [OrderID], [Active]) VALUES (19, 4, N'bnhgjkld', NULL, 1)
SET IDENTITY_INSERT [dbo].[Cart] OFF
GO
SET IDENTITY_INSERT [dbo].[Cart_Product] ON 

INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (2, 1, 5, 1, 500000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (3, 1, 8, 2, 200000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (4, NULL, NULL, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (5, NULL, 11, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (6, 1, 11, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (7, 1, 11, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (8, 3, 5, 4, 400000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (9, 3, 5, 2, 200000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (10, 3, 5, 2, 200000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (11, 2, 5, 1, 100000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (12, 2, 5, 1, 100000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (13, 2, 5, 2, 200000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (14, 2, 5, 1, 100000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (15, 2, 5, 1, 100000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (16, 3, 5, 7, 700000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (17, 2, 5, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (18, 2, 5, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (19, 2, 5, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (20, 7, 15, 3, 687000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (21, 7, 14, 2, 560000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (22, 7, 14, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (23, 2, 12, 1, 159000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (24, 2, 12, 1, 159000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (25, 2, 12, 1, 159000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (26, 2, 12, 1, 159000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (27, 2, 12, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (28, 2, 12, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (29, 2, 12, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (30, 2, 5, 1, 100000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (31, 2, 5, 0, 0)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (32, 1, 14, 2, 560000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (33, 2, 17, 1, 649000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (34, 12, 26, 2, 770000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (36, 12, 13, 1, 300000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (43, 12, 25, 1, 119000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (45, 3, 26, 1, 385000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (46, 16, 8, 1, 95000)
INSERT [dbo].[Cart_Product] ([id], [CartID], [ProductID], [quantity], [totalPrice]) VALUES (47, 13, 5, 2, 200000)
SET IDENTITY_INSERT [dbo].[Cart_Product] OFF
GO
SET IDENTITY_INSERT [dbo].[Order_User] ON 

INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (2, 1, 1, 1260000, N'A102 duong Vo Van Ngan quan 9', CAST(N'2023-12-13' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (3, 1, 1, 1260000, N'Quan 12 TPHCM', CAST(N'2023-12-13' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (4, 2, 1, 1985000, N'Quan 12 TPHCM', CAST(N'2023-12-13' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (5, 12, 1, 1189000, N'', CAST(N'2023-12-14' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (6, 7, 1, 1247000, N'', CAST(N'2023-12-14' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (7, 3, 1, 1885000, N'A123 duong Vo Nguyen Gap', CAST(N'2023-12-14' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (8, 16, 1, 95000, N'A123 duong 123', CAST(N'2023-12-14' AS Date), NULL, NULL)
INSERT [dbo].[Order_User] ([OrderID], [CartID], [Paid], [Total], [Adress], [OrderDate], [ArriveDate], [cart]) VALUES (9, 13, 1, 200000, N'', CAST(N'2023-12-15' AS Date), NULL, NULL)
SET IDENTITY_INSERT [dbo].[Order_User] OFF
GO
SET IDENTITY_INSERT [dbo].[Product_Types] ON 

INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (1, N'Micellar water', N'Code011699633713682.jpg', N'Code01', 1)
INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (2, N'Cleanser', N'Code021699765800382.jpg', N'Code02', 1)
INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (8, N'Toner', N'Code041699609699017.jpg', N'Code04', 1)
INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (10, N'Serum', N'Code051699629515050.jpg', N'Code05', 1)
INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (20, N'Moisturizing cream', N'Code061699634024424.jpg', N'Code06', 1)
INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (27, N'Moisturizing eyes cream', N'Code071699634319017.jpg', N'Code07', 0)
INSERT [dbo].[Product_Types] ([TypeID], [TypeName], [Images], [TypeCode], [Status]) VALUES (32, N'Lipstick', N'Code071699716437116.jpg', N'Code Hot lipstick', 1)
SET IDENTITY_INSERT [dbo].[Product_Types] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (5, N'Simple Micellar Water', 1, 1, 7, 100000, 198, N'Micellar water for sensitive skin', N'simple_micellar.png', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (8, N'The Face Shop Vitamin C Brightening Serum', 10, 14, 1, 95000, 500, N'Serum removes brown spots, fade freckles, and dark spots on the skin by up tp 98%, bringing radiant skin full of vitality', N'The Face Shop Vitamin C Brightening Serum1700190435713.png', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (11, N'ABC', 1, 1, 7, 190, 0, N'GHJKL', NULL, 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (12, N'Simple Soothing Eye Balm', 27, 1, 8, 159000, 500, N'Revitalize the tired skin around the eyes, such as wrinkles, dryness, and dark circles', N'Simple Soothing Eye Balm1700463088885.jpg', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (13, N'The Face Shop Chia Seed Hydrating Toner', 8, 14, 8, 300000, 190, N'The best toner for dry skin', N'The Face Shop Chia Seed Hydrating Toner1700843536555.jpeg', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (14, N'Micellar Foaming Gel Cleanser for Combination to Oily Skin', 2, 11, 3, 280000, 200, N'This oil-free, fragrance-free, paraben-free foaming face wash for oily skin, cleanses and removes makeup', N'Micellar Foaming Gel Cleanser for Combination to Oily Skin1702276749278.jpg', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (15, N'L’Oréal Paris Aura Perfect Night Cream for radiant glow', 20, 12, 1, 229000, 129, N'A powerful skin brightening night cream & face moisturizer created by L''Oréal SkinCare Laboratories, for overnight skin brightening benefits for a radiant look', N'L’Oréal Paris Aura Perfect Night Cream for radiant glow1702278014495.jpg', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (17, N'New Bold Velvet Lipstick 3.5g', 32, 14, 1, 649000, 123, N'Perfect lipstick', N'New Bold Velvet Lipstick 3.5g1702359883002.png', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (25, N'THE FACE SHOP Herb Day 365 Acerola', 2, 14, 8, 119000, 345, N'123', N'THE FACE SHOP Herb Day 365 Acerola1702361121215.jpg', 0, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (26, N'The Faceshop Pomegranate And Collagen Volume Lifting Eye Cream', 27, 14, 1, 385000, 100, N'New Item', N'The Faceshop Pomegranate And Collagen Volume Lifting Eye Cream1702361307207.jpg', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (27, N'CeraVe Anti Aging Retinol Serum', 10, 13, 7, 235000, 300, N'New Serum', N'CeraVe Anti Aging Retinol Serum1702361434055.jpg', 1, NULL)
INSERT [dbo].[Products] ([ProductID], [ProductName], [TypeID], [SupplierID], [SkinID], [Price], [Amount], [Description], [Images], [Status], [CartID]) VALUES (29, N'Simple Daily Detox Purifying Gel Face Wash For Oily Skin, 150 ml', 2, 1, 3, 135000, 200, N'Simple Daily Detox Purifying Gel Face Wash suitable for oily, spot prone skin. 5% witch hazel blend, Zinc, Vitamin B5, Niacinamide and pro amino acids.', N'Simple Daily Detox Purifying Gel Face Wash For Oily Skin, 150 ml1702538916187.jpg', 1, NULL)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Skins] ON 

INSERT [dbo].[Skins] ([SkinID], [SkinName], [Images]) VALUES (1, N'Normal skin ', N'Normal skin 123451699718373969.jpg')
INSERT [dbo].[Skins] ([SkinID], [SkinName], [Images]) VALUES (3, N'Oily skin', N'Oily skin1699717593316.png')
INSERT [dbo].[Skins] ([SkinID], [SkinName], [Images]) VALUES (6, N'Acne skin', N'Acne skin1699718669033.jpg')
INSERT [dbo].[Skins] ([SkinID], [SkinName], [Images]) VALUES (7, N'Sensitive skin', N'Sensitive skin1699718685643.jpg')
INSERT [dbo].[Skins] ([SkinID], [SkinName], [Images]) VALUES (8, N'Dry skin', N'Dry skin1699718703469.jpg')
SET IDENTITY_INSERT [dbo].[Skins] OFF
GO
SET IDENTITY_INSERT [dbo].[Suppliers] ON 

INSERT [dbo].[Suppliers] ([SupplierID], [SupplierName], [Country], [Images], [Status]) VALUES (1, N'Simple', N'United Kingdom', N'simple.png', 1)
INSERT [dbo].[Suppliers] ([SupplierID], [SupplierName], [Country], [Images], [Status]) VALUES (2, N'Biodrema', N'France', N'Bioderma.png', 1)
INSERT [dbo].[Suppliers] ([SupplierID], [SupplierName], [Country], [Images], [Status]) VALUES (11, N'Garnier', N'France', N'France1699770465287.png', 1)
INSERT [dbo].[Suppliers] ([SupplierID], [SupplierName], [Country], [Images], [Status]) VALUES (12, N'L''oréal', N'France', N'France1699770720889.png', 1)
INSERT [dbo].[Suppliers] ([SupplierID], [SupplierName], [Country], [Images], [Status]) VALUES (13, N'CeraVe', N'USA', N'USA1699892393827.png', 1)
INSERT [dbo].[Suppliers] ([SupplierID], [SupplierName], [Country], [Images], [Status]) VALUES (14, N'The Face Shop', N'Korea', N'thefaceshop.png', 1)
SET IDENTITY_INSERT [dbo].[Suppliers] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserID], [Active], [Admin], [Email], [Fullname], [Images], [Password], [Phone], [Username]) VALUES (1, 1, 0, N'phuongngan.nguyen2304@gmail.com', N'Phuong Ngan', N'null1702438551192.JPG', N'hwOCt3XWNs', N'0123456789', N'ngan')
INSERT [dbo].[Users] ([UserID], [Active], [Admin], [Email], [Fullname], [Images], [Password], [Phone], [Username]) VALUES (2, 1, 0, N'rose.nguyen123@gmail.com', N'Rose Nguyen', NULL, N'123456', N'099999999', N'rose')
INSERT [dbo].[Users] ([UserID], [Active], [Admin], [Email], [Fullname], [Images], [Password], [Phone], [Username]) VALUES (3, 0, 1, N'rose.nguyen123@gmail.com', N'ABC', N'null1702438510519.jpg', N'123456', N'099999999', N'abc')
INSERT [dbo].[Users] ([UserID], [Active], [Admin], [Email], [Fullname], [Images], [Password], [Phone], [Username]) VALUES (4, 1, 0, N'nguyenvana@gmail.com', N'Yen Nhi', N'null1702438580728.png', N'123', N'12345670', N'nhi')
INSERT [dbo].[Users] ([UserID], [Active], [Admin], [Email], [Fullname], [Images], [Password], [Phone], [Username]) VALUES (5, 1, 0, N'minhtri@123gmail.com', N'Nguyen Minh Tri', NULL, N'123', N'0987654321', N'tri')
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_uid] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_uid]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FKukeivieq0po0od81c5hnlgpe] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Order_User] ([OrderID])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FKukeivieq0po0od81c5hnlgpe]
GO
ALTER TABLE [dbo].[Cart_Product]  WITH CHECK ADD  CONSTRAINT [FK_cartid] FOREIGN KEY([CartID])
REFERENCES [dbo].[Cart] ([CartID])
GO
ALTER TABLE [dbo].[Cart_Product] CHECK CONSTRAINT [FK_cartid]
GO
ALTER TABLE [dbo].[Cart_Product]  WITH CHECK ADD  CONSTRAINT [FK_pid] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Cart_Product] CHECK CONSTRAINT [FK_pid]
GO
ALTER TABLE [dbo].[Order_User]  WITH CHECK ADD  CONSTRAINT [FK_ordercartid] FOREIGN KEY([CartID])
REFERENCES [dbo].[Cart] ([CartID])
GO
ALTER TABLE [dbo].[Order_User] CHECK CONSTRAINT [FK_ordercartid]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_skinid] FOREIGN KEY([SkinID])
REFERENCES [dbo].[Skins] ([SkinID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_skinid]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_supplierid] FOREIGN KEY([SupplierID])
REFERENCES [dbo].[Suppliers] ([SupplierID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_supplierid]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_typeid] FOREIGN KEY([TypeID])
REFERENCES [dbo].[Product_Types] ([TypeID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_typeid]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKe4dbtfm1f7u64fw86hx6ofr3k] FOREIGN KEY([CartID])
REFERENCES [dbo].[Cart_Product] ([id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKe4dbtfm1f7u64fw86hx6ofr3k]
GO
