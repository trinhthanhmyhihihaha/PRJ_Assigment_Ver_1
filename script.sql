USE [master]
GO
/****** Object:  Database [Project_Prj_Ver1]    Script Date: 9/25/2023 11:05:20 PM ******/
CREATE DATABASE [Project_Prj_Ver1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Project_Prj_Ver1', FILENAME = N'D:\SSMS\MSSQL16.MSSQLSERVER\MSSQL\DATA\Project_Prj_Ver1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Project_Prj_Ver1_log', FILENAME = N'D:\SSMS\MSSQL16.MSSQLSERVER\MSSQL\DATA\Project_Prj_Ver1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Project_Prj_Ver1] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Project_Prj_Ver1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Project_Prj_Ver1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET ARITHABORT OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Project_Prj_Ver1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Project_Prj_Ver1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Project_Prj_Ver1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Project_Prj_Ver1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Project_Prj_Ver1] SET  MULTI_USER 
GO
ALTER DATABASE [Project_Prj_Ver1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Project_Prj_Ver1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Project_Prj_Ver1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Project_Prj_Ver1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Project_Prj_Ver1] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Project_Prj_Ver1] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Project_Prj_Ver1] SET QUERY_STORE = ON
GO
ALTER DATABASE [Project_Prj_Ver1] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Project_Prj_Ver1]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[cid] [nvarchar](50) NOT NULL,
	[cname] [nvarchar](50) NULL,
	[semester] [int] NULL,
 CONSTRAINT [PK_Course] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Final_Result]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Final_Result](
	[fr_id] [int] IDENTITY(1,1) NOT NULL,
	[scoreID] [int] NULL,
	[status] [nvarchar](50) NULL,
 CONSTRAINT [PK_Final_Result] PRIMARY KEY CLUSTERED 
(
	[fr_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Group]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group](
	[gid] [nvarchar](50) NOT NULL,
	[gname] [nvarchar](50) NULL,
 CONSTRAINT [PK_Group] PRIMARY KEY CLUSTERED 
(
	[gid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Group_member]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group_member](
	[gid] [nvarchar](50) NULL,
	[sid] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Instructor]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Instructor](
	[iID] [nvarchar](50) NOT NULL,
	[iname] [nvarchar](50) NULL,
	[iusername] [varchar](50) NULL,
	[ipassword] [varchar](50) NULL,
	[istatus] [bit] NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Instructor] PRIMARY KEY CLUSTERED 
(
	[iID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[rid] [int] NULL,
	[rname] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Schedule]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedule](
	[scheduleid] [int] IDENTITY(1,1) NOT NULL,
	[iID] [nvarchar](50) NULL,
	[gid] [nvarchar](50) NULL,
	[cid] [nvarchar](50) NULL,
	[startdate] [date] NULL,
	[enddate] [date] NULL,
 CONSTRAINT [PK_Schedule] PRIMARY KEY CLUSTERED 
(
	[scheduleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Scores]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Scores](
	[scoreID] [int] IDENTITY(1,1) NOT NULL,
	[sid] [nvarchar](50) NULL,
	[gid] [nvarchar](50) NULL,
	[pt1_score] [float] NULL,
	[pt2_score] [float] NULL,
	[pt3_score] [float] NULL,
	[pe] [float] NULL,
	[fe] [float] NULL,
	[total_score] [float] NULL,
 CONSTRAINT [PK_Scores] PRIMARY KEY CLUSTERED 
(
	[scoreID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Status]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Status](
	[sttid] [int] IDENTITY(1,1) NOT NULL,
	[sid] [nvarchar](50) NULL,
	[check] [date] NULL,
	[slot] [int] NULL,
	[status] [nvarchar](50) NULL,
	[scheduleid] [int] NULL,
 CONSTRAINT [PK_Status] PRIMARY KEY CLUSTERED 
(
	[sttid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 9/25/2023 11:05:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[sid] [nvarchar](50) NOT NULL,
	[sname] [nvarchar](50) NULL,
	[susername] [nvarchar](50) NULL,
	[spassword] [varchar](50) NULL,
	[sstatus] [bit] NULL,
	[avatar] [image] NULL,
	[role] [int] NULL,
	[dob] [date] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Final_Result]  WITH CHECK ADD  CONSTRAINT [FK_Final_Result_Scores] FOREIGN KEY([scoreID])
REFERENCES [dbo].[Scores] ([scoreID])
GO
ALTER TABLE [dbo].[Final_Result] CHECK CONSTRAINT [FK_Final_Result_Scores]
GO
ALTER TABLE [dbo].[Group_member]  WITH CHECK ADD  CONSTRAINT [FK_Group_member_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([gid])
GO
ALTER TABLE [dbo].[Group_member] CHECK CONSTRAINT [FK_Group_member_Group]
GO
ALTER TABLE [dbo].[Group_member]  WITH CHECK ADD  CONSTRAINT [FK_Group_member_Student] FOREIGN KEY([sid])
REFERENCES [dbo].[Student] ([sid])
GO
ALTER TABLE [dbo].[Group_member] CHECK CONSTRAINT [FK_Group_member_Student]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Course] FOREIGN KEY([cid])
REFERENCES [dbo].[Course] ([cid])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Course]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([gid])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Group]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Instructor] FOREIGN KEY([iID])
REFERENCES [dbo].[Instructor] ([iID])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Instructor]
GO
ALTER TABLE [dbo].[Scores]  WITH CHECK ADD  CONSTRAINT [FK_Scores_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([gid])
GO
ALTER TABLE [dbo].[Scores] CHECK CONSTRAINT [FK_Scores_Group]
GO
ALTER TABLE [dbo].[Scores]  WITH CHECK ADD  CONSTRAINT [FK_Scores_Student] FOREIGN KEY([sid])
REFERENCES [dbo].[Student] ([sid])
GO
ALTER TABLE [dbo].[Scores] CHECK CONSTRAINT [FK_Scores_Student]
GO
ALTER TABLE [dbo].[Status]  WITH CHECK ADD  CONSTRAINT [FK_Status_Student] FOREIGN KEY([sid])
REFERENCES [dbo].[Student] ([sid])
GO
ALTER TABLE [dbo].[Status] CHECK CONSTRAINT [FK_Status_Student]
GO
USE [master]
GO
ALTER DATABASE [Project_Prj_Ver1] SET  READ_WRITE 
GO
