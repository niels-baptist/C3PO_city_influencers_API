# C3PO_city_influencers_API
This is the repository used by team C3PO for the course Project 4.0 at Thomas More.
This API is used to retrieve data from the database hosted on Azure cloud.
Below you can find documentation on the different api calls.

## API calls

- #1: [GET] /users/username/{username} : Get the following data from a user with the given username.
    - username 
    - firstname
    - lastname
    - birthdate
    - email
    - location id
    - location name
    - postal code

- #2: [GET] /employees/username/{username} : This is to be used for authentication on the web application. It gets the same data as Get request #1 but from an influencer with the given username (string).

- #3 [GET] /influencer/username/{username} : This is to be used for authentication on the mobile application. It gets the same data as Get request #1 but from a user with the given username (string).

- #4 [GET] /users/id/{id}: It gets the same data as Get request #1 but from a user with the given user_id (integer).

