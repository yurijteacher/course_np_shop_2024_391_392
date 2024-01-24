ALTER TABLE `_order` ADD COLUMN `delivery` VARCHAR(45) NULL AFTER `clientes_id`;
ALTER TABLE `_order` ADD COLUMN `payment` VARCHAR(45) NULL AFTER `delivery`;