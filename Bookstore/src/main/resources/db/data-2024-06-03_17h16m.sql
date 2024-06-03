-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book_categories`
--

DROP TABLE IF EXISTS `book_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_categories` (
  `ID_BOOK` bigint NOT NULL,
  `ID_CATEGORY` bigint NOT NULL,
  PRIMARY KEY (`ID_BOOK`,`ID_CATEGORY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_categories`
--

LOCK TABLES `book_categories` WRITE;
/*!40000 ALTER TABLE `book_categories` DISABLE KEYS */;
INSERT INTO `book_categories` VALUES (1,7),(2,9),(3,9),(4,6),(5,4),(6,5),(7,3),(8,3),(9,7),(10,4),(11,2),(12,9),(13,7),(14,4),(15,2),(16,3),(17,6),(18,5),(19,5),(20,8),(21,6),(22,8),(23,8),(24,4),(25,8),(26,6),(27,3),(28,9),(29,9),(30,7),(31,2),(32,5),(33,2),(34,5),(35,4),(36,6),(37,5),(38,2),(39,5),(40,9),(41,5),(42,6),(43,3),(44,9),(45,8),(46,9),(47,8),(48,5),(49,3),(50,1);
/*!40000 ALTER TABLE `book_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `PUBLISHER` varchar(255) NOT NULL,
  `SUMMARY` varchar(2000) NOT NULL,
  `IMG` varchar(255) NOT NULL,
  `PRICE` float(10,2) NOT NULL,
  `ISBN` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Precious Bane Book','Mittie Rau II','Left Book Club','Porro sunt quia facere non quam ut qui. Quia consequatur et eos iusto ipsa delectus. Odio distinctio fugit deleniti maxime facilis velit. Magnam autem quis quasi quia animi ullam quo. Voluptates voluptas quos.','https://th.bing.com/th/id/OIP.s5Xa4Jeg5AS_YdWkYahtYgAAAA?rs=1&pid=ImgDetMain',453400.56,'9780901296887'),(2,'The Man Within','Ericka McDermott IV','Carnegie Mellon University Press','Ad blanditiis enim sit. Fugit alias voluptatem blanditiis voluptatem rem laboriosam non. Soluta eos et ut molestiae sunt ut qui. Adipisci ab earum molestias hic officiis eveniet dicta. Beatae iusto quis quia dignissimos cum.','https://th.bing.com/th/id/OIP.oM_GpiaOOVRmnYGihHh1wAAAAA?rs=1&pid=ImgDetMain',432722.41,'9790328750039'),(3,'Ego Dominus Tuus','Edgar Klein','G. P. Putnam\'s Sons','Expedita magnam quas. Officiis accusamus vitae. Nihil voluptas accusantium maiores eum. Voluptates fugit architecto sunt quasi neque. Officia ex quis iusto nemo.','https://th.bing.com/th/id/OIP.hMLlb-uq9In7fM1NJnDiVAAAAA?rs=1&pid=ImgDetMain',320016.94,'9791792053404'),(4,'The Waste Land','Isaias Barrows I','Bellevue Literary Press','Consequuntur voluptatibus velit beatae minima provident voluptatem tempora. Autem veniam harum quos tenetur aperiam. Incidunt repellendus distinctio autem cupiditate neque ut. Nobis illo nulla totam optio. Sint minima sit quos perspiciatis possimus optio.','https://th.bing.com/th/id/OIP.2Tbz_127E-iDEpMxIMHlXwHaLI?rs=1&pid=ImgDetMain',322899.75,'9791045162563'),(5,'The Moving Finger','Jody Ullrich II','Athabasca University Press','Quia voluptatum ut nisi. Optio et id est architecto. Ea veniam quis tempora quod et sit et. Nesciunt itaque placeat autem.','https://img1.od-cdn.com/ImageType-100/0211-1/%7B0509C29D-3E11-43B7-AA90-97D716CC0DD3%7DImg100.jpg',222444.03,'9780022535322'),(6,'Oh! To be in England','Corene Labadie Sr.','Black Library','Ratione rem sunt ducimus officia. Excepturi eveniet sit exercitationem consequatur. Ut esse numquam omnis dolorem molestiae veritatis saepe.','https://th.bing.com/th/id/OIP.2fjuAZi6CkePFCN9XqrF2gHaLX?rs=1&pid=ImgDetMain',53170.70,'9781002619063'),(7,'The House of Mirth','Danilo Ritchie','Breslov Research Institute','Voluptas sit quos. Quibusdam magni fugit rerum vel omnis assumenda nihil. Non dolores atque et. Nihil sint amet labore. Dolores soluta est quisquam.','https://th.bing.com/th/id/OIP.uir-2dxA6lPFtMLK59bbvAHaMA?w=196&h=318&c=7&r=0&o=5&dpr=1.3&pid=1.7',209565.53,'9781918488166'),(8,'Beneath the Bleeding','Ghislaine Schultz','Booktrope','Iusto ducimus temporibus. Quia hic debitis voluptatum voluptatibus voluptatum distinctio. Adipisci inventore eum. Dolor quasi illum ratione qui possimus earum. Molestiae ut voluptatem occaecati.','https://th.bing.com/th/id/OIP.wp3R1hwxlrGgsMze3Fs5mwAAAA?w=115&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7',223337.88,'9780503005207'),(9,'The Last Enemy','Blair Kuhlman','Farrar, Straus & Giroux','Quas consequuntur hic sit officia natus sunt vel. Unde dolorem magni ab culpa. Expedita iusto cumque amet autem. Explicabo in vel laudantium. Autem iure cum sequi et velit vel.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',137907.97,'9791950905965'),(10,'Beneath the Bleeding','Miki Stracke DVM','Elsevier','Assumenda deserunt laborum quia qui ut maiores. Et est excepturi quidem provident. Sequi fugiat vero qui. Et ipsum aut rerum.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',337196.75,'9791966483648'),(11,'An Evil Cradling','Mrs. Brenton Treutel','Ballantine Books','Ad illum ipsum adipisci quidem. Quia inventore aliquam ipsa quae saepe qui repellendus. Id nobis voluptates consequatur sapiente itaque nulla rerum. Voluptas accusamus beatae dolorem porro occaecati ullam enim.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',420068.84,'9781803060163'),(12,'Infinite Jest','Jermaine White','Marshall Cavendish','Esse tenetur culpa. Voluptate porro repudiandae voluptatem non. Repellat eveniet quaerat aspernatur illum. Doloremque eveniet rem sed dolorum quidem facilis velit.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',116856.95,'9790931082626'),(13,'The Doors of Perception','Ned Hayes','Pecan Grove Press','Sit molestias laudantium blanditiis odio explicabo inventore quibusdam. Impedit atque repellendus. Et repellat quia. Est asperiores dolor placeat et sunt. Sint ea sed maiores.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',155912.73,'9781881960461'),(14,'Precious Bane','Mr. Saul Zemlak','Tarpaulin Sky Press','Eaque aperiam sit. Voluptatem consequuntur voluptatibus fuga repellat eos. Quos doloribus perferendis ad non molestiae itaque velit.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',387481.28,'9780967512440'),(15,'The Way of All Flesh','Miss Agueda Boehm','Koren Publishers Jerusalem','Tenetur nesciunt rerum eos maxime et ut aut. Tempore et sed et. Quo necessitatibus dolorum dicta qui sed aspernatur qui. Quis rerum dolore sed in molestiae exercitationem rem. Hic ut facere mollitia ut atque dolor.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',50135.19,'9780738116709'),(16,'The Other Side of Silence','Jesenia Heathcote','Open University Press','Minima asperiores nesciunt perferendis quos aut sint. Vitae odit id. Aut iste illum ea id at. Ullam est et quasi incidunt aperiam.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',108778.87,'9791094544495'),(17,'Noli Me Tangere','Gabriel Ferry','Imperial War Museum','Neque placeat quis molestiae voluptatem sit. Consequatur quia et esse sunt voluptas assumenda. Eos qui possimus tenetur.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',314643.38,'9781877086458'),(18,'A Many-Splendoured Thing','Riley Crist','Burns & Oates','Corporis pariatur quia animi ab repudiandae maxime. Iusto iure voluptas qui voluptatem qui accusamus sunt. Quia nam non sunt qui eum praesentium quo. Provident officia ut iure perspiciatis. Odit neque velit officiis corporis dicta molestias.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',375146.41,'9780756517199'),(19,'Moab Is My Washpot','Humberto Tromp','Sams Publishing','Eum qui consequatur eligendi pariatur labore. Odit eos omnis ut dolores dolor. Dolore dolorem id sit dolore sunt tenetur.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',78939.71,'9790901887787'),(20,'Ego Dominus Tuus','Everett Larkin','Lethe Press','Vel soluta nihil ut non animi aperiam. Deserunt quae quo autem veniam. Magni dolore ducimus illo id ab. Unde non cupiditate animi iusto dolores sunt.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',349522.12,'9781990196614'),(21,'The Painted Veil','Pearle Mills','Mainstream Publishing','Nulla animi suscipit deserunt. Est architecto sint et. Ipsum debitis eaque similique.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',145329.58,'9791739979361'),(22,'The Curious Incident of the Dog in the Night-Time','Bernard Bernier Jr.','Pantheon Books at Random House','Veritatis optio facere quo dolorem voluptates sequi non. Est in veritatis doloribus qui molestias maxime. Harum cumque numquam ut nesciunt mollitia dignissimos. Natus sit non omnis quas.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',17232.26,'9791869413018'),(23,'Look Homeward, Angel','Nena Hoeger MD','New Holland Publishers','Ratione quod aperiam. Officiis ipsa enim molestias. Velit dolores repellat in quia cupiditate. Dolores eligendi iure et pariatur et laboriosam. Provident voluptas impedit tempore rerum.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',253015.59,'9791762522343'),(24,'Postern of Fate','Mrs. Estella Raynor','Shuter & Shooter Publishers','Iusto esse placeat iure quod qui. Laboriosam dolorem impedit cumque. Architecto nemo perspiciatis. Eaque sed iste dolor iure.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',25952.71,'9790578498194'),(25,'Ah, Wilderness!','Fred Cormier MD','Hodder Headline','Sed voluptas quia optio id quas sed. Enim nihil sint quisquam qui. Ratione harum dolorum veniam voluptas. Quos corrupti quo nihil ut ut facere. Magni dolor et exercitationem cumque possimus.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',495448.81,'9780917265211'),(26,'Moab Is My Washpot','Mr. Jose Nienow','John Blake Publishing','Necessitatibus minima recusandae sit saepe quis quos. Dicta nulla minima. Saepe nam in illum voluptas. Voluptatem molestias est quae mollitia.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',249815.81,'9781883834517'),(27,'Terrible Swift Sword','Keri Spinka','Mapin Publishing','Iste aut omnis aperiam odit. Velit labore nostrum. Perspiciatis id necessitatibus. Voluptatem repudiandae voluptatibus dolorem et praesentium amet.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',135519.98,'9790980376783'),(28,'The Little Foxes','Terrilyn Hickle','Scholastic Press','Qui ad necessitatibus officia odit nihil delectus. Non animi sunt voluptatum tempore provident. Blanditiis quia in dicta eligendi.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',41742.58,'9781260786217'),(29,'Consider Phlebas','Araceli Denesik PhD','Ace Books','Accusamus quis consectetur dolorum sint. Necessitatibus nemo asperiores. Maxime voluptates autem qui qui quae eum.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',342679.84,'9781877441356'),(30,'Mother Night','Numbers Hyatt','Sidgwick & Jackson','Rerum aut est. Minima fugiat et delectus consequatur nam natus. Quasi quas nesciunt sit. Et ipsam ullam dolores qui.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',325087.94,'9780301720289'),(31,'Absalom, Absalom!','Odessa Leffler','E. P. Dutton','Magni et adipisci voluptas voluptatibus sit. Asperiores cupiditate labore libero quos. Occaecati et blanditiis ducimus.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',106728.72,'9780042116150'),(32,'Françoise Sagan','Humberto Schmeler','McGraw Hill Financial','Deleniti rerum dolor. Et voluptate laudantium. Nihil eligendi voluptas nobis in quam voluptatem. Aliquid cupiditate aspernatur reiciendis consectetur aut.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',483019.09,'9790983923649'),(33,'Endless Night','Letisha Sporer','No Starch Press','Est corporis ut omnis eum aut qui minus. Vero modi minima consequatur. Quia magni aspernatur ut molestiae molestiae pariatur.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',379882.41,'9781881698333'),(34,'It\'s a Battlefield','Marion Mosciski','Atheneum Books','Ratione sit labore veniam maxime esse assumenda. In nostrum facere voluptas quia. Et minus reprehenderit placeat expedita beatae voluptatem. Voluptas autem eum numquam autem omnis sed.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',186626.09,'9781057132074'),(35,'A Time of Gifts','Denis Hickle III','Golden Cockerel Press','Cum aut qui sapiente. Facere consequatur corrupti. Expedita dolorem vitae qui dolor repellat sequi porro. Ab excepturi et quae.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',290326.75,'9781476334875'),(36,'Nectar in a Sieve','Miss Migdalia McDermott','D. Appleton & Company','Aut aut tenetur ipsam nobis illo animi. Natus accusantium soluta eius perspiciatis. Perspiciatis excepturi amet temporibus.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',94960.88,'9780945823407'),(37,'Of Human Bondage','Mr. Hyun Howe','Focal Press','Aut fugiat officiis dolor sed distinctio. Temporibus excepturi perspiciatis. Quia enim aut ex rerum culpa voluptatem veniam. Ipsa voluptatibus id.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',282770.41,'9791874495344'),(38,'To Say Nothing of the Dog','Suzanne Pfannerstill','ECW Press','Delectus ex eveniet deserunt numquam. Vero dolor minus temporibus. Corrupti delectus ratione nobis pariatur et.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',99720.76,'9790285157346'),(39,'This Lime Tree Bower','Nola Ryan','Allen Ltd','Voluptas repellat quasi quod fuga. Voluptas laudantium ipsam nesciunt. Itaque maiores doloremque mollitia earum et. Aut est provident velit. Iure iste ut ut possimus.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',164239.38,'9791823646704'),(40,'This Side of Paradise','Shauna Thompson','Hawthorne Books','Quasi id tempore id. Et qui quia fuga laborum. Aut necessitatibus aperiam odit animi eius.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',426954.91,'9791909278720'),(41,'Ego Dominus Tuus','Lucius Hilll II','Ballantine Books','Molestiae sunt omnis tempore praesentium sunt. Sapiente voluptatibus deserunt qui sequi voluptatem blanditiis. Culpa minus tempora consectetur. Ab dolorem quos velit. Sed qui ut a.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',306190.34,'9790916536533'),(42,'Antic Hay','Dr. Kyle Nitzsche','Pen and Sword Books','Earum esse mollitia blanditiis voluptatem. Similique ut doloribus et neque et. Neque consectetur necessitatibus. Perferendis alias id.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',98899.98,'9781098214265'),(43,'A Glass of Blessings','Norberto Mohr','Harlequin Enterprises Ltd','Maiores sunt officia. Eius perferendis debitis consequuntur. Et nemo consequatur eum est expedita.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',106699.82,'9781017706314'),(44,'Postern of Fate','Wan Lang','Pantheon Books at Random House','Consequuntur voluptates quae aut. Pariatur dolor occaecati possimus. Quae ut ad fugit eos.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',485772.72,'9790357036906'),(45,'Ring of Bright Water','Mrs. Gil Blick','Berg Publishers','Ut est perferendis provident amet eligendi rerum labore. Ullam est totam et distinctio laborum recusandae molestias. Dolorum exercitationem excepturi minus pariatur.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',154875.44,'9781303322501'),(46,'Jacob Have I Loved','Mr. Fermin Balistreri','Dalkey Archive Press','Hic ipsum minus nulla. Nihil in rem voluptatem doloremque. Tenetur distinctio porro sunt eum. Accusantium voluptatem molestias ab laborum sed.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',213160.41,'9781751202707'),(47,'Recalled to Life','Mrs. Rufus Lebsack','Nonesuch Press','Harum qui libero. Sed nesciunt voluptas. Quis vero numquam doloremque temporibus quia sunt exercitationem. Quod mollitia rerum inventore reiciendis. Sunt debitis dicta fugit assumenda blanditiis iste doloremque.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',495711.62,'9781005815448'),(48,'Many Waters','Teodoro Koepp','Mandrake of Oxford','Neque nisi ratione. Et quasi in voluptate voluptate voluptatem cum culpa. Quidem et ea ducimus quis sed consectetur iusto. Enim voluptatem dolorem. Non nesciunt eligendi.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',243472.31,'9781918531671'),(49,'An Evil Cradling','Maria Green','Canongate Books','Voluptas impedit unde quo voluptates aut totam ut. Et odio quia eos molestias necessitatibus qui nobis. Iusto odio eum occaecati possimus atque exercitationem molestiae. Et soluta dolorum rerum. Illo et quo accusantium occaecati temporibus.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',181987.56,'9791391484937'),(50,'The Waste Land','Hulda Reilly Sr.','Breslov Research Institute','Reprehenderit placeat reiciendis hic nihil. Ea soluta qui dolor voluptatem aut vitae. Dolorem explicabo blanditiis molestias.','https://th.bing.com/th/id/R.4bb48e3d8165f8162c5c56e1041cfc56?rik=EkRKDE53gvDGcg&pid=ImgRaw&r=0',283477.19,'9780885365746');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_details`
--

DROP TABLE IF EXISTS `cart_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_details` (
  `cart_id` bigint NOT NULL,
  `book_id` bigint NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`cart_id`,`book_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `cart_details_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  CONSTRAINT `cart_details_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_details`
--

LOCK TABLES `cart_details` WRITE;
/*!40000 ALTER TABLE `cart_details` DISABLE KEYS */;
INSERT INTO `cart_details` VALUES (30,2,1,432722.41);
/*!40000 ALTER TABLE `cart_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `carts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (30,28);
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(256) NOT NULL,
  `DESCRIPTION` varchar(2000) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Suspense/Thriller','Ut animi tempora dolore libero quis.'),(2,'Horror','Voluptate quas iste sed maxime amet voluptatem error.'),(3,'Realistic fiction','Dolorem veniam ipsam ut esse.'),(4,'Fiction narrative','Impedit unde blanditiis voluptas hic facilis.'),(5,'Science fiction','Et in ullam earum sint.'),(6,'Fiction narrative','Et iste ab hic et aperiam ab nobis.'),(7,'Horror','Quo alias sint voluptate porro voluptatem et provident.'),(8,'Fiction in verse','Minima rem eum cumque provident qui voluptas.'),(9,'Suspense/Thriller','Ut esse fuga error inventore.'),(10,'Fantasy','Fugiat veniam nam laborum voluptatem perspiciatis aut.');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forgot_passwords`
--

DROP TABLE IF EXISTS `forgot_passwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forgot_passwords` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `token` varchar(255) NOT NULL,
  `expires` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `forgot_passwords_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forgot_passwords`
--

LOCK TABLES `forgot_passwords` WRITE;
/*!40000 ALTER TABLE `forgot_passwords` DISABLE KEYS */;
/*!40000 ALTER TABLE `forgot_passwords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `cart_id` bigint NOT NULL,
  `payment_status` enum('PENDING','SUCCESS','FAILED') NOT NULL DEFAULT 'PENDING',
  `payment_method` enum('VNPAY','CASH') NOT NULL DEFAULT 'CASH',
  `total` double NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `cart_id` (`cart_id`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`),
  CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `FULL_NAME` varchar(255) NOT NULL,
  `PASSWD` varchar(128) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `DOB` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Octavio Toy','3kitzr1lzx7','samella.stehr@hotmail.com','1187 Lissette Via, Katihaven, KS 52489-2582','2005-07-20 17:00:00'),(2,'Gregoria Schamberger IV','8nvnd543zvc1st4','marinda.dietrich@hotmail.com','Suite 886 24454 Irina Island, Tashashire, CO 82420','1974-01-15 17:00:00'),(3,'Kami Mosciski','aty3af5r','lyndsey.williamson@yahoo.com','Suite 081 014 Nikolaus Lights, North Shenitachester, PA 56616-0429','1999-07-05 17:00:00'),(4,'Dr. Leeanna Murray','47l6n4zlj','jonathon.jakubowski@gmail.com','Suite 428 147 Melaine Land, Victorinamouth, KY 98742','1974-12-19 17:00:00'),(5,'Mr. Angelo Langworth','5p1gtowzo2kohu6','gracia.kub@yahoo.com','6584 Howard Inlet, New Gene, NH 61644-1747','2000-05-12 17:00:00'),(6,'Georgene Boyer','klhrlyli8o5','danyelle.nienow@hotmail.com','Apt. 776 17418 Deangelo Field, Daylestad, OH 59369','1974-11-23 17:00:00'),(7,'Mr. Vania Toy','1v13zemla68rzg','tatiana.herman@hotmail.com','Apt. 832 69107 Gerry Knolls, Claudineberg, AL 23100-0235','1979-07-14 17:00:00'),(8,'Mrs. Monika Kassulke','oibtooh79d1a','robin.gusikowski@hotmail.com','0793 Rusty Shoal, East Judi, OH 04864-3888','1973-06-11 17:00:00'),(9,'Loyce Mayert','uny5j9uu2yoa1','sherman.stracke@gmail.com','2845 Yost Dale, Elviraville, OH 52863','1979-06-05 17:00:00'),(10,'Alexis Orn','q3kkiovg67','rosella.shanahan@yahoo.com','Suite 461 94370 Malik Summit, New Cheryll, TX 13045','1991-11-11 17:00:00'),(11,'Mrs. Enedina Kreiger','iimg45erjdns4','dahlia.lehner@yahoo.com','60842 Cruickshank Valleys, Schustermouth, ID 55361','1987-06-05 17:00:00'),(12,'Norris Wyman','lyotui7rz1vf','cristina.senger@gmail.com','3131 Larraine Squares, New Kyra, GA 01335','1973-12-12 17:00:00'),(13,'Bernie Steuber','dymv3sehx','margarett.reilly@yahoo.com','Apt. 962 6813 Lacie Views, Denesikchester, MS 56319-9113','2006-04-02 17:00:00'),(14,'Melody Turcotte','jo8v1jm1ml','maurice.weissnat@gmail.com','Suite 787 6669 O\'Keefe Villages, Thielchester, IN 48294','2005-04-30 17:00:00'),(15,'Dillon Bergnaum','hzsoikmb','ami.blick@gmail.com','Suite 753 5117 Dibbert Forge, Keeblerfurt, WA 05521-3288','1974-08-03 17:00:00'),(28,'Trần Thắng Lợi','199afc940591d13219d82d9eda8544275234c64cb5f2571b00096e3cd24a7da1','thangloitran406@gmail.com','75/3 Tân Lập, Đông Hoà','2003-08-08 17:00:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verify_emails`
--

DROP TABLE IF EXISTS `verify_emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verify_emails` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `email` varchar(255) NOT NULL COMMENT 'Email',
  `token` varchar(255) NOT NULL COMMENT 'Token',
  `expires` timestamp NOT NULL COMMENT 'Expires',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `verify_emails_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verify_emails`
--

LOCK TABLES `verify_emails` WRITE;
/*!40000 ALTER TABLE `verify_emails` DISABLE KEYS */;
/*!40000 ALTER TABLE `verify_emails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-03 17:16:52
