#Istore
Desktop application using ## JavaFX
# Project Specifications

## Basic Authentication
- Setup basic authentication.
- On application start, prompt users to create an account with email and password.
- Implement login functionality using email and password.
- Only allow account creation for whitelisted email addresses.
- Store passwords securely (not in plain text).
- Provide clear error messages during login or account creation failures.

## User Management
- Implement CRUD operations for user management.
- User attributes: id, email, pseudo, password, role.
- Normal users can view other users' information except for passwords.
- Allow creating a new user without login, provided the email is whitelisted.
- Users can only update their own information unless they are admins.
- Users can only delete their own accounts unless they are admins.

## Admin Management
- The first user or a default user should be an admin.
- Admins can whitelist emails for registration.
- Admins have the ability to update or delete any user account.
- Admins can create a new store.
- Admins can manage inventory items, including creation and deletion.

## Inventory Management
- Each store is linked to a single inventory.
- Inventory items include: id, name, price, and stock quantity.
- Prevent stock quantity from dropping below 0.
- Enable browsing of the inventory to display all items.
- Employees can modify the stock quantity of items.

## Store Management
- Only admins can create or delete stores.
- Stores include: id and name.
- Each store is linked to one inventory.
- Admins can assign employees to a store.
- Restrict store access to assigned employees and admins.
- Display a list of users with access to the store for admins and assigned employees.
## Screens
![WhatsApp Image 2024-02-22 at 21 40 00](https://github.com/IkhlasQass19/Istore/assets/129891260/bede2346-37c1-47dc-af6e-7b31229aa95d)
![WhatsApp Image 2024-02-22 at 21 41 53](https://github.com/IkhlasQass19/Istore/assets/129891260/67959e2e-ef43-4876-821b-c5f799b53d43)
![WhatsApp Image 2024-02-22 at 21 42 36](https://github.com/IkhlasQass19/Istore/assets/129891260/4cb1d5dd-dbaa-4bf4-abc1-42a8b927acd4)
![WhatsApp Image 2024-02-22 at 21 46 12](https://github.com/IkhlasQass19/Istore/assets/129891260/836e5be9-8bae-4422-aea9-93317bbc29ce)




