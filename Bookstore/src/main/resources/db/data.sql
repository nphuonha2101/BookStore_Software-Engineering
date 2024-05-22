-- Tạo bảng Users
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `ID`        bigint AUTO_INCREMENT,
    `FULL_NAME` varchar(255) NOT NULL,
    `PASSWD`    varchar(128) NOT NULL,
    `EMAIL`     varchar(255) NOT NULL,
    `ADDRESS`   varchar(255) NOT NULL,
    `DOB`       timestamp NULL,
    PRIMARY KEY (`ID`)
);

-- Tạo bảng Books
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`
(
    `ID`        bigint AUTO_INCREMENT,
    `TITLE`     varchar(255)  NOT NULL,
    `AUTHOR`    varchar(255)  NOT NULL,
    `PUBLISHER` varchar(255)  NOT NULL,
    `SUMMARY`    varchar(2000) NOT NULL,
    `IMG`       varchar(255)  NOT NULL,
    `PRICE`     float(10, 2) NOT NULL,
    `ISBN` varchar(255) NOT NULL,

  PRIMARY KEY (`ID`)
);

-- Tạo bảng Categories
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`
(
    `ID`           bigint AUTO_INCREMENT,
    `NAME`         varchar(256)  NOT NULL,
    `DESCRIPTION` varchar(2000) NOT NULL,
    PRIMARY KEY (`ID`)
);

-- Tạo bảng Book Category
DROP TABLE IF EXISTS `book_categories`;
CREATE TABLE `book_categories`
(
    `ID_BOOK`     bigint REFERENCES BOOKS (`ID`),
    `ID_CATEGORY` bigint REFERENCES CATEGORIES (`ID1`),
  PRIMARY KEY (`ID_BOOK`, `ID_CATEGORY`)
);

-- Insert dữ liệu vào bảng Users
insert into bookstore.users (ID, FULL_NAME, PASSWD, EMAIL, ADDRESS, DOB)
values  (1, 'Octavio Toy', '3kitzr1lzx7', 'samella.stehr@hotmail.com', '1187 Lissette Via, Katihaven, KS 52489-2582', '2005-07-21 00:00:00'),
        (2, 'Gregoria Schamberger IV', '8nvnd543zvc1st4', 'marinda.dietrich@hotmail.com', 'Suite 886 24454 Irina Island, Tashashire, CO 82420', '1974-01-16 00:00:00'),
        (3, 'Kami Mosciski', 'aty3af5r', 'lyndsey.williamson@yahoo.com', 'Suite 081 014 Nikolaus Lights, North Shenitachester, PA 56616-0429', '1999-07-06 00:00:00'),
        (4, 'Dr. Leeanna Murray', '47l6n4zlj', 'jonathon.jakubowski@gmail.com', 'Suite 428 147 Melaine Land, Victorinamouth, KY 98742', '1974-12-20 00:00:00'),
        (5, 'Mr. Angelo Langworth', '5p1gtowzo2kohu6', 'gracia.kub@yahoo.com', '6584 Howard Inlet, New Gene, NH 61644-1747', '2000-05-13 00:00:00'),
        (6, 'Georgene Boyer', 'klhrlyli8o5', 'danyelle.nienow@hotmail.com', 'Apt. 776 17418 Deangelo Field, Daylestad, OH 59369', '1974-11-24 00:00:00'),
        (7, 'Mr. Vania Toy', '1v13zemla68rzg', 'tatiana.herman@hotmail.com', 'Apt. 832 69107 Gerry Knolls, Claudineberg, AL 23100-0235', '1979-07-15 00:00:00'),
        (8, 'Mrs. Monika Kassulke', 'oibtooh79d1a', 'robin.gusikowski@hotmail.com', '0793 Rusty Shoal, East Judi, OH 04864-3888', '1973-06-12 00:00:00'),
        (9, 'Loyce Mayert', 'uny5j9uu2yoa1', 'sherman.stracke@gmail.com', '2845 Yost Dale, Elviraville, OH 52863', '1979-06-06 00:00:00'),
        (10, 'Alexis Orn', 'q3kkiovg67', 'rosella.shanahan@yahoo.com', 'Suite 461 94370 Malik Summit, New Cheryll, TX 13045', '1991-11-12 00:00:00'),
        (11, 'Mrs. Enedina Kreiger', 'iimg45erjdns4', 'dahlia.lehner@yahoo.com', '60842 Cruickshank Valleys, Schustermouth, ID 55361', '1987-06-06 00:00:00'),
        (12, 'Norris Wyman', 'lyotui7rz1vf', 'cristina.senger@gmail.com', '3131 Larraine Squares, New Kyra, GA 01335', '1973-12-13 00:00:00'),
        (13, 'Bernie Steuber', 'dymv3sehx', 'margarett.reilly@yahoo.com', 'Apt. 962 6813 Lacie Views, Denesikchester, MS 56319-9113', '2006-04-03 00:00:00'),
        (14, 'Melody Turcotte', 'jo8v1jm1ml', 'maurice.weissnat@gmail.com', 'Suite 787 6669 O''Keefe Villages, Thielchester, IN 48294', '2005-05-01 00:00:00'),
        (15, 'Dillon Bergnaum', 'hzsoikmb', 'ami.blick@gmail.com', 'Suite 753 5117 Dibbert Forge, Keeblerfurt, WA 05521-3288', '1974-08-04 00:00:00');

-- Insert dữ liệu vào bảng Books
insert into bookstore.books (ID, TITLE, AUTHOR, PUBLISHER, SUMMARY, IMG, PRICE, ISBN)
values  (1, 'Precious Bane', 'Mittie Rau II', 'Left Book Club', 'Porro sunt quia facere non quam ut qui. Quia consequatur et eos iusto ipsa delectus. Odio distinctio fugit deleniti maxime facilis velit. Magnam autem quis quasi quia animi ullam quo. Voluptates voluptas quos.', 'http://lorempixel.com/g/720/348/animals/', 453400.56, '9780901296887'),
        (2, 'The Man Within', 'Ericka McDermott IV', 'Carnegie Mellon University Press', 'Ad blanditiis enim sit. Fugit alias voluptatem blanditiis voluptatem rem laboriosam non. Soluta eos et ut molestiae sunt ut qui. Adipisci ab earum molestias hic officiis eveniet dicta. Beatae iusto quis quia dignissimos cum.', 'http://lorempixel.com/g/1024/768/food/', 432722.4, '9790328750039'),
        (3, 'Ego Dominus Tuus', 'Edgar Klein', 'G. P. Putnam''s Sons', 'Expedita magnam quas. Officiis accusamus vitae. Nihil voluptas accusantium maiores eum. Voluptates fugit architecto sunt quasi neque. Officia ex quis iusto nemo.', 'http://lorempixel.com/640/350/cats/', 320016.94, '9791792053404'),
        (4, 'The Waste Land', 'Isaias Barrows I', 'Bellevue Literary Press', 'Consequuntur voluptatibus velit beatae minima provident voluptatem tempora. Autem veniam harum quos tenetur aperiam. Incidunt repellendus distinctio autem cupiditate neque ut. Nobis illo nulla totam optio. Sint minima sit quos perspiciatis possimus optio.', 'http://lorempixel.com/g/720/348/sports/', 322899.75, '9791045162563'),
        (5, 'The Moving Finger', 'Jody Ullrich II', 'Athabasca University Press', 'Quia voluptatum ut nisi. Optio et id est architecto. Ea veniam quis tempora quod et sit et. Nesciunt itaque placeat autem.', 'http://lorempixel.com/g/640/200/food/', 222444.03, '9780022535322'),
        (6, 'Oh! To be in England', 'Corene Labadie Sr.', 'Black Library', 'Ratione rem sunt ducimus officia. Excepturi eveniet sit exercitationem consequatur. Ut esse numquam omnis dolorem molestiae veritatis saepe.', 'http://lorempixel.com/g/1366/768/abstract/', 53170.7, '9781002619063'),
        (7, 'The House of Mirth', 'Danilo Ritchie', 'Breslov Research Institute', 'Voluptas sit quos. Quibusdam magni fugit rerum vel omnis assumenda nihil. Non dolores atque et. Nihil sint amet labore. Dolores soluta est quisquam.', 'http://lorempixel.com/320/200/technics/', 209565.53, '9781918488166'),
        (8, 'Beneath the Bleeding', 'Ghislaine Schultz', 'Booktrope', 'Iusto ducimus temporibus. Quia hic debitis voluptatum voluptatibus voluptatum distinctio. Adipisci inventore eum. Dolor quasi illum ratione qui possimus earum. Molestiae ut voluptatem occaecati.', 'http://lorempixel.com/g/1920/1200/transport/', 223337.88, '9780503005207'),
        (9, 'The Last Enemy', 'Blair Kuhlman', 'Farrar, Straus & Giroux', 'Quas consequuntur hic sit officia natus sunt vel. Unde dolorem magni ab culpa. Expedita iusto cumque amet autem. Explicabo in vel laudantium. Autem iure cum sequi et velit vel.', 'http://lorempixel.com/1024/768/business/', 137907.97, '9791950905965'),
        (10, 'Beneath the Bleeding', 'Miki Stracke DVM', 'Elsevier', 'Assumenda deserunt laborum quia qui ut maiores. Et est excepturi quidem provident. Sequi fugiat vero qui. Et ipsum aut rerum.', 'http://lorempixel.com/g/1366/768/food/', 337196.75, '9791966483648'),
        (11, 'An Evil Cradling', 'Mrs. Brenton Treutel', 'Ballantine Books', 'Ad illum ipsum adipisci quidem. Quia inventore aliquam ipsa quae saepe qui repellendus. Id nobis voluptates consequatur sapiente itaque nulla rerum. Voluptas accusamus beatae dolorem porro occaecati ullam enim.', 'http://lorempixel.com/g/1680/1050/people/', 420068.84, '9781803060163'),
        (12, 'Infinite Jest', 'Jermaine White', 'Marshall Cavendish', 'Esse tenetur culpa. Voluptate porro repudiandae voluptatem non. Repellat eveniet quaerat aspernatur illum. Doloremque eveniet rem sed dolorum quidem facilis velit.', 'http://lorempixel.com/1680/1050/technics/', 116856.95, '9790931082626'),
        (13, 'The Doors of Perception', 'Ned Hayes', 'Pecan Grove Press', 'Sit molestias laudantium blanditiis odio explicabo inventore quibusdam. Impedit atque repellendus. Et repellat quia. Est asperiores dolor placeat et sunt. Sint ea sed maiores.', 'http://lorempixel.com/g/1024/768/nature/', 155912.73, '9781881960461'),
        (14, 'Precious Bane', 'Mr. Saul Zemlak', 'Tarpaulin Sky Press', 'Eaque aperiam sit. Voluptatem consequuntur voluptatibus fuga repellat eos. Quos doloribus perferendis ad non molestiae itaque velit.', 'http://lorempixel.com/g/1920/1200/cats/', 387481.28, '9780967512440'),
        (15, 'The Way of All Flesh', 'Miss Agueda Boehm', 'Koren Publishers Jerusalem', 'Tenetur nesciunt rerum eos maxime et ut aut. Tempore et sed et. Quo necessitatibus dolorum dicta qui sed aspernatur qui. Quis rerum dolore sed in molestiae exercitationem rem. Hic ut facere mollitia ut atque dolor.', 'http://lorempixel.com/g/640/200/technics/', 50135.19, '9780738116709'),
        (16, 'The Other Side of Silence', 'Jesenia Heathcote', 'Open University Press', 'Minima asperiores nesciunt perferendis quos aut sint. Vitae odit id. Aut iste illum ea id at. Ullam est et quasi incidunt aperiam.', 'http://lorempixel.com/1366/768/people/', 108778.87, '9791094544495'),
        (17, 'Noli Me Tangere', 'Gabriel Ferry', 'Imperial War Museum', 'Neque placeat quis molestiae voluptatem sit. Consequatur quia et esse sunt voluptas assumenda. Eos qui possimus tenetur.', 'http://lorempixel.com/g/1024/768/people/', 314643.38, '9781877086458'),
        (18, 'A Many-Splendoured Thing', 'Riley Crist', 'Burns & Oates', 'Corporis pariatur quia animi ab repudiandae maxime. Iusto iure voluptas qui voluptatem qui accusamus sunt. Quia nam non sunt qui eum praesentium quo. Provident officia ut iure perspiciatis. Odit neque velit officiis corporis dicta molestias.', 'http://lorempixel.com/1024/768/city/', 375146.4, '9780756517199'),
        (19, 'Moab Is My Washpot', 'Humberto Tromp', 'Sams Publishing', 'Eum qui consequatur eligendi pariatur labore. Odit eos omnis ut dolores dolor. Dolore dolorem id sit dolore sunt tenetur.', 'http://lorempixel.com/640/350/people/', 78939.71, '9790901887787'),
        (20, 'Ego Dominus Tuus', 'Everett Larkin', 'Lethe Press', 'Vel soluta nihil ut non animi aperiam. Deserunt quae quo autem veniam. Magni dolore ducimus illo id ab. Unde non cupiditate animi iusto dolores sunt.', 'http://lorempixel.com/g/1680/1050/people/', 349522.12, '9781990196614'),
        (21, 'The Painted Veil', 'Pearle Mills', 'Mainstream Publishing', 'Nulla animi suscipit deserunt. Est architecto sint et. Ipsum debitis eaque similique.', 'http://lorempixel.com/1600/1200/nature/', 145329.58, '9791739979361'),
        (22, 'The Curious Incident of the Dog in the Night-Time', 'Bernard Bernier Jr.', 'Pantheon Books at Random House', 'Veritatis optio facere quo dolorem voluptates sequi non. Est in veritatis doloribus qui molestias maxime. Harum cumque numquam ut nesciunt mollitia dignissimos. Natus sit non omnis quas.', 'http://lorempixel.com/640/480/food/', 17232.26, '9791869413018'),
        (23, 'Look Homeward, Angel', 'Nena Hoeger MD', 'New Holland Publishers', 'Ratione quod aperiam. Officiis ipsa enim molestias. Velit dolores repellat in quia cupiditate. Dolores eligendi iure et pariatur et laboriosam. Provident voluptas impedit tempore rerum.', 'http://lorempixel.com/320/200/people/', 253015.6, '9791762522343'),
        (24, 'Postern of Fate', 'Mrs. Estella Raynor', 'Shuter & Shooter Publishers', 'Iusto esse placeat iure quod qui. Laboriosam dolorem impedit cumque. Architecto nemo perspiciatis. Eaque sed iste dolor iure.', 'http://lorempixel.com/g/640/480/nightlife/', 25952.71, '9790578498194'),
        (25, 'Ah, Wilderness!', 'Fred Cormier MD', 'Hodder Headline', 'Sed voluptas quia optio id quas sed. Enim nihil sint quisquam qui. Ratione harum dolorum veniam voluptas. Quos corrupti quo nihil ut ut facere. Magni dolor et exercitationem cumque possimus.', 'http://lorempixel.com/g/640/480/cats/', 495448.8, '9780917265211'),
        (26, 'Moab Is My Washpot', 'Mr. Jose Nienow', 'John Blake Publishing', 'Necessitatibus minima recusandae sit saepe quis quos. Dicta nulla minima. Saepe nam in illum voluptas. Voluptatem molestias est quae mollitia.', 'http://lorempixel.com/1280/1024/transport/', 249815.81, '9781883834517'),
        (27, 'Terrible Swift Sword', 'Keri Spinka', 'Mapin Publishing', 'Iste aut omnis aperiam odit. Velit labore nostrum. Perspiciatis id necessitatibus. Voluptatem repudiandae voluptatibus dolorem et praesentium amet.', 'http://lorempixel.com/640/480/fashion/', 135519.98, '9790980376783'),
        (28, 'The Little Foxes', 'Terrilyn Hickle', 'Scholastic Press', 'Qui ad necessitatibus officia odit nihil delectus. Non animi sunt voluptatum tempore provident. Blanditiis quia in dicta eligendi.', 'http://lorempixel.com/1366/768/technics/', 41742.58, '9781260786217'),
        (29, 'Consider Phlebas', 'Araceli Denesik PhD', 'Ace Books', 'Accusamus quis consectetur dolorum sint. Necessitatibus nemo asperiores. Maxime voluptates autem qui qui quae eum.', 'http://lorempixel.com/g/1920/1200/nightlife/', 342679.84, '9781877441356'),
        (30, 'Mother Night', 'Numbers Hyatt', 'Sidgwick & Jackson', 'Rerum aut est. Minima fugiat et delectus consequatur nam natus. Quasi quas nesciunt sit. Et ipsam ullam dolores qui.', 'http://lorempixel.com/640/200/abstract/', 325087.94, '9780301720289'),
        (31, 'Absalom, Absalom!', 'Odessa Leffler', 'E. P. Dutton', 'Magni et adipisci voluptas voluptatibus sit. Asperiores cupiditate labore libero quos. Occaecati et blanditiis ducimus.', 'http://lorempixel.com/g/320/200/nature/', 106728.72, '9780042116150'),
        (32, 'Françoise Sagan', 'Humberto Schmeler', 'McGraw Hill Financial', 'Deleniti rerum dolor. Et voluptate laudantium. Nihil eligendi voluptas nobis in quam voluptatem. Aliquid cupiditate aspernatur reiciendis consectetur aut.', 'http://lorempixel.com/1024/768/cats/', 483019.1, '9790983923649'),
        (33, 'Endless Night', 'Letisha Sporer', 'No Starch Press', 'Est corporis ut omnis eum aut qui minus. Vero modi minima consequatur. Quia magni aspernatur ut molestiae molestiae pariatur.', 'http://lorempixel.com/g/1280/1024/nightlife/', 379882.4, '9781881698333'),
        (34, 'It''s a Battlefield', 'Marion Mosciski', 'Atheneum Books', 'Ratione sit labore veniam maxime esse assumenda. In nostrum facere voluptas quia. Et minus reprehenderit placeat expedita beatae voluptatem. Voluptas autem eum numquam autem omnis sed.', 'http://lorempixel.com/1280/1024/abstract/', 186626.1, '9781057132074'),
        (35, 'A Time of Gifts', 'Denis Hickle III', 'Golden Cockerel Press', 'Cum aut qui sapiente. Facere consequatur corrupti. Expedita dolorem vitae qui dolor repellat sequi porro. Ab excepturi et quae.', 'http://lorempixel.com/1600/1200/technics/', 290326.75, '9781476334875'),
        (36, 'Nectar in a Sieve', 'Miss Migdalia McDermott', 'D. Appleton & Company', 'Aut aut tenetur ipsam nobis illo animi. Natus accusantium soluta eius perspiciatis. Perspiciatis excepturi amet temporibus.', 'http://lorempixel.com/g/1024/768/nature/', 94960.88, '9780945823407'),
        (37, 'Of Human Bondage', 'Mr. Hyun Howe', 'Focal Press', 'Aut fugiat officiis dolor sed distinctio. Temporibus excepturi perspiciatis. Quia enim aut ex rerum culpa voluptatem veniam. Ipsa voluptatibus id.', 'http://lorempixel.com/320/200/fashion/', 282770.4, '9791874495344'),
        (38, 'To Say Nothing of the Dog', 'Suzanne Pfannerstill', 'ECW Press', 'Delectus ex eveniet deserunt numquam. Vero dolor minus temporibus. Corrupti delectus ratione nobis pariatur et.', 'http://lorempixel.com/1024/768/city/', 99720.76, '9790285157346'),
        (39, 'This Lime Tree Bower', 'Nola Ryan', 'Allen Ltd', 'Voluptas repellat quasi quod fuga. Voluptas laudantium ipsam nesciunt. Itaque maiores doloremque mollitia earum et. Aut est provident velit. Iure iste ut ut possimus.', 'http://lorempixel.com/g/640/350/people/', 164239.38, '9791823646704'),
        (40, 'This Side of Paradise', 'Shauna Thompson', 'Hawthorne Books', 'Quasi id tempore id. Et qui quia fuga laborum. Aut necessitatibus aperiam odit animi eius.', 'http://lorempixel.com/g/640/350/cats/', 426954.9, '9791909278720'),
        (41, 'Ego Dominus Tuus', 'Lucius Hilll II', 'Ballantine Books', 'Molestiae sunt omnis tempore praesentium sunt. Sapiente voluptatibus deserunt qui sequi voluptatem blanditiis. Culpa minus tempora consectetur. Ab dolorem quos velit. Sed qui ut a.', 'http://lorempixel.com/g/720/348/city/', 306190.34, '9790916536533'),
        (42, 'Antic Hay', 'Dr. Kyle Nitzsche', 'Pen and Sword Books', 'Earum esse mollitia blanditiis voluptatem. Similique ut doloribus et neque et. Neque consectetur necessitatibus. Perferendis alias id.', 'http://lorempixel.com/320/200/sports/', 98899.98, '9781098214265'),
        (43, 'A Glass of Blessings', 'Norberto Mohr', 'Harlequin Enterprises Ltd', 'Maiores sunt officia. Eius perferendis debitis consequuntur. Et nemo consequatur eum est expedita.', 'http://lorempixel.com/g/1680/1050/technics/', 106699.82, '9781017706314'),
        (44, 'Postern of Fate', 'Wan Lang', 'Pantheon Books at Random House', 'Consequuntur voluptates quae aut. Pariatur dolor occaecati possimus. Quae ut ad fugit eos.', 'http://lorempixel.com/g/1024/768/cats/', 485772.72, '9790357036906'),
        (45, 'Ring of Bright Water', 'Mrs. Gil Blick', 'Berg Publishers', 'Ut est perferendis provident amet eligendi rerum labore. Ullam est totam et distinctio laborum recusandae molestias. Dolorum exercitationem excepturi minus pariatur.', 'http://lorempixel.com/720/348/nature/', 154875.44, '9781303322501'),
        (46, 'Jacob Have I Loved', 'Mr. Fermin Balistreri', 'Dalkey Archive Press', 'Hic ipsum minus nulla. Nihil in rem voluptatem doloremque. Tenetur distinctio porro sunt eum. Accusantium voluptatem molestias ab laborum sed.', 'http://lorempixel.com/320/200/technics/', 213160.4, '9781751202707'),
        (47, 'Recalled to Life', 'Mrs. Rufus Lebsack', 'Nonesuch Press', 'Harum qui libero. Sed nesciunt voluptas. Quis vero numquam doloremque temporibus quia sunt exercitationem. Quod mollitia rerum inventore reiciendis. Sunt debitis dicta fugit assumenda blanditiis iste doloremque.', 'http://lorempixel.com/g/1366/768/food/', 495711.62, '9781005815448'),
        (48, 'Many Waters', 'Teodoro Koepp', 'Mandrake of Oxford', 'Neque nisi ratione. Et quasi in voluptate voluptate voluptatem cum culpa. Quidem et ea ducimus quis sed consectetur iusto. Enim voluptatem dolorem. Non nesciunt eligendi.', 'http://lorempixel.com/1680/1050/people/', 243472.31, '9781918531671'),
        (49, 'An Evil Cradling', 'Maria Green', 'Canongate Books', 'Voluptas impedit unde quo voluptates aut totam ut. Et odio quia eos molestias necessitatibus qui nobis. Iusto odio eum occaecati possimus atque exercitationem molestiae. Et soluta dolorum rerum. Illo et quo accusantium occaecati temporibus.', 'http://lorempixel.com/g/640/200/city/', 181987.56, '9791391484937'),
        (50, 'The Waste Land', 'Hulda Reilly Sr.', 'Breslov Research Institute', 'Reprehenderit placeat reiciendis hic nihil. Ea soluta qui dolor voluptatem aut vitae. Dolorem explicabo blanditiis molestias.', 'http://lorempixel.com/1366/768/fashion/', 283477.2, '9780885365746');

-- Insert dữ liệu vào bảng Categories
insert into bookstore.categories (ID, NAME, DESCRIPTION)
values  (1, 'Suspense/Thriller', 'Ut animi tempora dolore libero quis.'),
        (2, 'Horror', 'Voluptate quas iste sed maxime amet voluptatem error.'),
        (3, 'Realistic fiction', 'Dolorem veniam ipsam ut esse.'),
        (4, 'Fiction narrative', 'Impedit unde blanditiis voluptas hic facilis.'),
        (5, 'Science fiction', 'Et in ullam earum sint.'),
        (6, 'Fiction narrative', 'Et iste ab hic et aperiam ab nobis.'),
        (7, 'Horror', 'Quo alias sint voluptate porro voluptatem et provident.'),
        (8, 'Fiction in verse', 'Minima rem eum cumque provident qui voluptas.'),
        (9, 'Suspense/Thriller', 'Ut esse fuga error inventore.'),
        (10, 'Fantasy', 'Fugiat veniam nam laborum voluptatem perspiciatis aut.');

-- Insert dữ liệu vào bảng Book Category
insert into bookstore.book_categories (ID_BOOK, ID_CATEGORY)
values  (1, 7),
        (2, 9),
        (3, 9),
        (4, 6),
        (5, 4),
        (6, 5),
        (7, 3),
        (8, 3),
        (9, 7),
        (10, 4),
        (11, 2),
        (12, 9),
        (13, 7),
        (14, 4),
        (15, 2),
        (16, 3),
        (17, 6),
        (18, 5),
        (19, 5),
        (20, 8),
        (21, 6),
        (22, 8),
        (23, 8),
        (24, 4),
        (25, 8),
        (26, 6),
        (27, 3),
        (28, 9),
        (29, 9),
        (30, 7),
        (31, 2),
        (32, 5),
        (33, 2),
        (34, 5),
        (35, 4),
        (36, 6),
        (37, 5),
        (38, 2),
        (39, 5),
        (40, 9),
        (41, 5),
        (42, 6),
        (43, 3),
        (44, 9),
        (45, 8),
        (46, 9),
        (47, 8),
        (48, 5),
        (49, 3),
        (50, 1);