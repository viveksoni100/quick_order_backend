-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 19, 2025 at 07:09 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quick_order`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `menu_id`, `name`) VALUES
(1, 2, 'Pizza'),
(3, 2, 'Burger'),
(4, 2, 'Chat');

-- --------------------------------------------------------

--
-- Table structure for table `city_master`
--

CREATE TABLE `city_master` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `short_code` varchar(10) DEFAULT NULL,
  `std_code` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `city_master`
--

INSERT INTO `city_master` (`id`, `name`, `short_code`, `std_code`) VALUES
(1, 'Ahmedabad', 'AMD', '079'),
(2, 'Rajkot', 'RJT', '0281');

-- --------------------------------------------------------

--
-- Table structure for table `country_master`
--

CREATE TABLE `country_master` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `short_code` varchar(10) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  `calling_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `country_master`
--

INSERT INTO `country_master` (`id`, `name`, `short_code`, `currency`, `calling_code`) VALUES
(1, 'India', 'IND', 'INR', '+91');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `ingredients` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_veg` tinyint(1) DEFAULT 1,
  `is_active` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `category_id`, `menu_id`, `name`, `description`, `price`, `ingredients`, `weight`, `image`, `is_veg`, `is_active`) VALUES
(1, 1, 2, 'Margherita', 'Margherita Pizza', 199, 'Dough, San Marzano tomato sauce, fresh mozzarella cheese, fresh basil, and extra-virgin olive oil.', '350 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/demouser/demo-outlet/pizza/p_marg_640x640.webp', 1, 1),
(2, 1, 2, 'Double Cheese', 'Double Cheese Pizza', 299, 'Dough, San Marzano tomato sauce, fresh mozzarella cheese, fresh basil, and extra-virgin olive oil.', '450 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/demouser/demo-outlet/pizza/p_marg_640x640.webp', 1, 1),
(3, 1, 2, 'Italian', 'Italian Pizza', 249, 'Dough, San Marzano tomato sauce, fresh mozzarella cheese, fresh basil, and extra-virgin olive oil.', '350 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/demouser/demo-outlet/pizza/p_marg_640x640.webp', 1, 1),
(5, 1, 2, 'Indian Wheat', 'Indian Special Wheat Pizza', 225, 'Dough, San Marzano tomato sauce, fresh mozzarella cheese, fresh basil, and extra-virgin olive oil.', '450 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/demouser/demo-outlet/pizza/p_marg_640x640.webp', 1, 1),
(6, 3, 2, 'Aloo Tikki', 'Aloo Tikki Burger', 99, 'mashed potatoes, peas, and Indian spices', '45 gram', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/demouser/demo-outlet/pizza/p_marg_640x640.webp', 1, 1),
(13, 4, 2, 'Bhel puri', 'Bhel puri with spice', 35, 'puri,sev,aloo etc.', '35 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/default.png', 1, 1),
(14, 3, 2, 'Mexican Burger', 'Mexican Burger', 15, '', '45 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/default.png', 1, 1),
(15, 4, 2, 'Sev puri', 'Special Sev puri', 25, 'NA', '25 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/default.png', 1, 1),
(17, 3, 2, 'Ham Burger', 'Cheese Ham Burger', 200, 'NA', '50 grams', 'https://raw.githubusercontent.com/viveksoni100/quick_order_images/refs/heads/main/default.png', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `outlet_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `is_active` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `user_id`, `outlet_id`, `name`, `is_active`) VALUES
(2, 2, 2, 'regular', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `bill_amount` double DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `discount_perc` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `platform_charge_perc` double DEFAULT NULL,
  `platform_charge_amount` double DEFAULT NULL,
  `outlet_id` int(11) NOT NULL,
  `order_qty` int(11) NOT NULL,
  `preparation_notes` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ip_address` varchar(255) DEFAULT NULL,
  `device` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `item_id` int(11) NOT NULL,
  `unit_price` double DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `total_amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_transactions`
--

CREATE TABLE `order_transactions` (
  `id` bigint(20) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `bill_amount` double DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `discount_perc` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `platform_charge_perc` double DEFAULT NULL,
  `platform_charge_amount` double DEFAULT NULL,
  `outlet_id` int(11) NOT NULL,
  `order_qty` int(11) NOT NULL,
  `preparation_notes` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ip_address` varchar(255) DEFAULT NULL,
  `device` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `outlet`
--

CREATE TABLE `outlet` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `pin_code` int(10) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `outlet`
--

INSERT INTO `outlet` (`id`, `user_id`, `name`, `address`, `city`, `pin_code`, `state`, `country`) VALUES
(2, 2, 'demo-outlet', 'racecourse ring road, beside galaxy cinema', 'Rajkot', 360001, 'Gujarat', 'India');

-- --------------------------------------------------------

--
-- Table structure for table `state_master`
--

CREATE TABLE `state_master` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `short_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `state_master`
--

INSERT INTO `state_master` (`id`, `name`, `short_code`) VALUES
(1, 'Gujarat', 'GJ');

-- --------------------------------------------------------

--
-- Table structure for table `table_info`
--

CREATE TABLE `table_info` (
  `id` int(11) NOT NULL,
  `table_no` varchar(255) NOT NULL,
  `outlet_id` int(11) NOT NULL,
  `sitting_capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$10$.9ZMpbtYrErczaC/R.VSoeFEk6pVSyU6vlOE9tjFdBuNPB0cL6qeK', 'ADMIN', 'superadmin'),
(2, '$2a$10$wmhH4ptpboMlVKRHSKzd9.Irt0L5XqV6L1jgK8Vo0w9zpdSj7gDbS', 'USER', 'demouser');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city_master`
--
ALTER TABLE `city_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country_master`
--
ALTER TABLE `country_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_transactions`
--
ALTER TABLE `order_transactions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `outlet`
--
ALTER TABLE `outlet`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `state_master`
--
ALTER TABLE `state_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_info`
--
ALTER TABLE `table_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `city_master`
--
ALTER TABLE `city_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `country_master`
--
ALTER TABLE `country_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order_info`
--
ALTER TABLE `order_info`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_transactions`
--
ALTER TABLE `order_transactions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `outlet`
--
ALTER TABLE `outlet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `state_master`
--
ALTER TABLE `state_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `table_info`
--
ALTER TABLE `table_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
