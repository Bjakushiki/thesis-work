-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: localhost
-- Létrehozás ideje: 2022. Ápr 29. 14:42
-- Kiszolgáló verziója: 8.0.27
-- PHP verzió: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `mydb`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `active_time_entity`
--

CREATE TABLE `active_time_entity` (
  `id` bigint NOT NULL,
  `arrival` datetime(6) DEFAULT NULL,
  `departure` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `active_time_entity`
--

INSERT INTO `active_time_entity` (`id`, `arrival`, `departure`) VALUES
(14, '2022-03-20 19:39:21.584186', '2022-03-20 19:39:24.195336'),
(15, '2022-03-20 19:41:42.531236', '2022-03-20 19:41:44.955916'),
(29, '2022-03-27 19:27:18.761049', '2022-03-27 20:59:58.116924'),
(38, '2022-04-10 10:14:19.712095', '2022-04-10 16:14:27.624616'),
(48, '2022-04-01 08:32:55.090882', '2022-04-01 16:32:59.543072'),
(49, '2022-04-19 10:33:03.870207', '2022-04-19 18:33:07.406119'),
(52, '2022-04-19 10:37:05.381679', '2022-04-19 10:43:27.789378'),
(53, '2022-04-19 10:55:48.354679', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(54);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `task_entity`
--

CREATE TABLE `task_entity` (
  `id` bigint NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `working_hours` bigint DEFAULT NULL,
  `assignee_id` bigint DEFAULT NULL,
  `reporter_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `task_entity`
--

INSERT INTO `task_entity` (`id`, `description`, `end_date`, `name`, `start_date`, `status`, `working_hours`, `assignee_id`, `reporter_id`) VALUES
(50, 'Ez egy minta feladat amit elvégeztünk', '2022-04-23 16:00:00.000000', 'Minta feladat', '2022-04-19 08:00:00.000000', 'FINISHED', NULL, 44, 44),
(51, 'Ez egy minta amit el kell végeznünk', NULL, 'Minta 2', '2022-04-19 10:35:28.255094', 'TODO', 479534284400, 44, 44);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_entity`
--

CREATE TABLE `user_entity` (
  `id` bigint NOT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `passwd` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `vacation_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `user_entity`
--

INSERT INTO `user_entity` (`id`, `is_admin`, `name`, `passwd`, `vacation_id`) VALUES
(9, b'1', 'Minta1', 'WVhOaw==', 10),
(16, NULL, 'Minta2', 'MTIz', 17),
(36, NULL, 'Minta3', 'YXNk', 37),
(44, b'1', 'Felhasználó', 'YXNk', 45);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_entity_active_times`
--

CREATE TABLE `user_entity_active_times` (
  `user_entity_id` bigint NOT NULL,
  `active_times_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `user_entity_active_times`
--

INSERT INTO `user_entity_active_times` (`user_entity_id`, `active_times_id`) VALUES
(9, 14),
(9, 15),
(9, 29),
(9, 38),
(44, 48),
(44, 49),
(44, 52),
(44, 53);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vacation_entity`
--

CREATE TABLE `vacation_entity` (
  `id` bigint NOT NULL,
  `all_vacation` int NOT NULL,
  `last_year_surplus` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `vacation_entity`
--

INSERT INTO `vacation_entity` (`id`, `all_vacation`, `last_year_surplus`) VALUES
(10, 30, 0),
(17, 30, 0),
(37, 30, 0),
(45, 30, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vacation_entity_vacation_time_list`
--

CREATE TABLE `vacation_entity_vacation_time_list` (
  `vacation_entity_id` bigint NOT NULL,
  `vacation_time_list_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `vacation_entity_vacation_time_list`
--

INSERT INTO `vacation_entity_vacation_time_list` (`vacation_entity_id`, `vacation_time_list_id`) VALUES
(10, 32),
(10, 33),
(10, 35),
(10, 39),
(17, 27),
(17, 34),
(45, 46),
(45, 47);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vacation_time_entity`
--

CREATE TABLE `vacation_time_entity` (
  `id` bigint NOT NULL,
  `end` datetime(6) DEFAULT NULL,
  `start` datetime(6) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `vacation_time_entity`
--

INSERT INTO `vacation_time_entity` (`id`, `end`, `start`, `type`) VALUES
(27, '2022-03-25 00:00:00.000000', '2022-03-20 00:00:00.000000', 'VACATION'),
(32, '2022-03-29 18:11:56.280000', '2022-03-27 18:13:27.883000', 'VACATION'),
(33, '2022-03-27 18:14:27.669000', '2022-03-27 18:14:27.669000', 'VACATION'),
(34, '2022-03-29 16:00:00.000000', '2022-03-28 08:00:00.000000', 'VACATION'),
(35, '2022-03-31 00:00:00.000000', '2022-03-29 00:00:00.000000', 'VACATION'),
(39, '2022-04-13 16:00:00.000000', '2022-04-11 08:00:00.000000', 'VACATION'),
(46, '2022-04-15 16:00:00.000000', '2022-04-10 08:00:00.000000', 'VACATION'),
(47, '2022-04-17 16:00:00.000000', '2022-04-17 08:00:00.000000', 'SICK_LEAVE');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `active_time_entity`
--
ALTER TABLE `active_time_entity`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `task_entity`
--
ALTER TABLE `task_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf6lemv3hgcoky3m2a7h8j8e8s` (`assignee_id`),
  ADD KEY `FKdwvkgaxks982y5y9fijaljgj3` (`reporter_id`);

--
-- A tábla indexei `user_entity`
--
ALTER TABLE `user_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn96wj4k0m0lq3pmuifbxea5e6` (`vacation_id`);

--
-- A tábla indexei `user_entity_active_times`
--
ALTER TABLE `user_entity_active_times`
  ADD UNIQUE KEY `UK_30vn7v4wa3klqd2rfh85fsn3r` (`active_times_id`),
  ADD KEY `FKalewb6hr6ltsbk8ot7hg74xe1` (`user_entity_id`);

--
-- A tábla indexei `vacation_entity`
--
ALTER TABLE `vacation_entity`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `vacation_entity_vacation_time_list`
--
ALTER TABLE `vacation_entity_vacation_time_list`
  ADD UNIQUE KEY `UK_dro1namhikglmcs9y0wtd5dpg` (`vacation_time_list_id`),
  ADD KEY `FKn7ffmx2a7pjdol6j1wedcocej` (`vacation_entity_id`);

--
-- A tábla indexei `vacation_time_entity`
--
ALTER TABLE `vacation_time_entity`
  ADD PRIMARY KEY (`id`);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `task_entity`
--
ALTER TABLE `task_entity`
  ADD CONSTRAINT `FKdwvkgaxks982y5y9fijaljgj3` FOREIGN KEY (`reporter_id`) REFERENCES `user_entity` (`id`),
  ADD CONSTRAINT `FKf6lemv3hgcoky3m2a7h8j8e8s` FOREIGN KEY (`assignee_id`) REFERENCES `user_entity` (`id`);

--
-- Megkötések a táblához `user_entity`
--
ALTER TABLE `user_entity`
  ADD CONSTRAINT `FKn96wj4k0m0lq3pmuifbxea5e6` FOREIGN KEY (`vacation_id`) REFERENCES `vacation_entity` (`id`);

--
-- Megkötések a táblához `user_entity_active_times`
--
ALTER TABLE `user_entity_active_times`
  ADD CONSTRAINT `FKa0nk7g9qpojyjon4fslc4x912` FOREIGN KEY (`active_times_id`) REFERENCES `active_time_entity` (`id`),
  ADD CONSTRAINT `FKalewb6hr6ltsbk8ot7hg74xe1` FOREIGN KEY (`user_entity_id`) REFERENCES `user_entity` (`id`);

--
-- Megkötések a táblához `vacation_entity_vacation_time_list`
--
ALTER TABLE `vacation_entity_vacation_time_list`
  ADD CONSTRAINT `FK2gi9sviro91f8b5bquiu4e6vh` FOREIGN KEY (`vacation_time_list_id`) REFERENCES `vacation_time_entity` (`id`),
  ADD CONSTRAINT `FKn7ffmx2a7pjdol6j1wedcocej` FOREIGN KEY (`vacation_entity_id`) REFERENCES `vacation_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
