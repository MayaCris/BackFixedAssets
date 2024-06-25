# BackFixedAssets

BackFixedAssets is a Java-based project designed to manage fixed assets within an organization. It provides functionalities for tracking asset details, depreciation, location, and responsible persons.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java OpenJDK 17
- Gradle 8.7 or higher
- Docker

### Installing

1. Clone the repository to your local machine:

```sh
git clone https://github.com/MayaCris/BackFixedAssets.git
```

2. Navigate to the project directory:

```sh
cd BackFixedAssets
```

3. Build the project using Gradle:

```sh
./gradlew clean build
```

4. Build the image and container with docker:

```sh
docker build -t fixed-asset:latest .
docker-compose -p assetapp up -d --build
```
If the spring-boot-app container is not running, please rerun the container manually.

## Usage

Once the project is up and running, you can access the following endpoints:

- `http://localhost:8070/fixed-Assets/api/fixedAsset/`

    - `/all`                    - Get a list of all assets
    - `/{personIdD}`            - Get details of an asset search by responsible person
    - `/findById/{assetIdD}`    - Get details of an asset search by ID
    - `/save`                   - Create a new asset
    - `/update/{assetIdD}`      - Update an existing asset
    - `/delete/{assetIdD}`      - Delete an asset

## Contributing

Contributions are welcome! If you would like to contribute to this project, please follow these steps:

1. Fork the repository
2. Create a new branch
3. Make your changes
4. Commit your changes
5. Push to the branch
6. Create a pull request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

