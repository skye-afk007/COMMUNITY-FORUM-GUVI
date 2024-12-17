# Online Community Forum 🌐

A web-based platform for community discussions, collaboration, and knowledge sharing. The application enables users to create threads, engage in discussions, and interact through various forum features.

## Features ✨

### User Features
- User Registration and Login
- Discussion Thread Creation
- Post Replies
- Upvote/Downvote System
- User Profile Management
- Search Functionality
- Notification System

### Admin Features
- User Management Dashboard
- Post Moderation
- Content Analytics
- Forum Settings Configuration
- User Activity Monitoring

## Technical Requirements 🛠️

- JDK 11
- Apache Maven 3.8 or higher
- Apache Tomcat 9.x
- MySQL 8.0
- Eclipse IDE or IntelliJ IDEA
- Git

## Project Structure 📁

```
community-forum/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── community/
│   │   │           ├── dao/
│   │   │               └── UserDAO.java
│   │   │           ├── model/
│   │   │               └── User.java
│   │   │           ├── servlet/
│   │   │               ├── LoginServlet.java
│   │   │               ├── ThreadServlet.java
│   │   │               └── ModeratePostServlet.java
│   │   │           └── util/
│   │   │               └── DatabaseUtil.java
│   │   ├── resources/
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           ├── web.xml
│   │           └── views/
│   │               ├── login.jsp
│   │               ├── forum.jsp
│   │               └── thread.jsp
│   └── test/
│       └── java/
└── pom.xml
```

## Dependencies 📚

```xml
<<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.onlinecommunityforum</groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>social-media-application-guvi</name>
	<description>Online Community forum project for GUVI hackathon</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```

## Database Configuration 🗄️

### MySQL Setup

1. Create the database:
```sql
CREATE DATABASE social_media;
USE social_media;
```

2. Create users table:
```sql

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE Posts (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Comments (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);
CREATE TABLE PostCategories (
    post_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (post_id, category_id),
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE CASCADE
);
CREATE TABLE Likes (
    like_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE
);
CREATE TABLE Followers (
    follower_id INT NOT NULL,
    followed_id INT NOT NULL,
    followed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (follower_id, followed_id),
    FOREIGN KEY (follower_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (followed_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Notifications (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    read_status BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE Messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    content TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (receiver_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE PostImages (
    image_id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE
);
CREATE TABLE ReportedPosts (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    reason TEXT NOT NULL,
    reported_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
CREATE TABLE SavedPosts (
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    saved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, post_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE
);
CREATE TABLE Tags (
    tag_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE PostTags (
    post_id INT NOT NULL,
    tag_id INT NOT NULL,
    PRIMARY KEY (post_id, tag_id),
    FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES Tags(tag_id) ON DELETE CASCADE
);


```

## Installation and Setup 🚀

### Prerequisites
1. Install JDK 11
2. Install Maven
3. Install MySQL 8.0
4. Install Apache Tomcat 9.x
5. Install your preferred IDE (Eclipse/IntelliJ)

### Steps
1. Clone the repository:
```bash
git clone https://github.com/skye-afk007/COMMUNITY-FORUM-GUVI.git
```

2. Configure database connection in `src/main/java/com/community/util/DatabaseUtil.java`:
```java
public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/communityforumdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    // ... rest of the configuration
}
```

3. Build the project:
```bash
mvn clean install
```

## Running the Project ▶️

### Development
1. Deploy the WAR file to Tomcat webapps directory
2. Start Tomcat server
3. Access the application at `http://localhost:8080/CommunityForum`

### Production Deployment
1. Build for production:
```bash
mvn clean package
```
2. Deploy the generated WAR file from `target/CommunityForum.war` to your production server

## Testing 🧪
Run the tests using:
```bash
mvn test
```

## Contact 📧

Project Maintainer - [@skye-afk007](https://github.com/skye-afk007), [@atulrai07](https://github.com/atulrai07)

Project Link: [https://github.com/skye-afk007/COMMUNITY-FORUM-GUVI.git](https://github.com/skye-afk007/COMMUNITY-FORUM-GUVI.git)
