
# Crud API Endpoints

## Creat Book

**Method:** POST

**Enpoints:** `http://localhost:9091/api/book/create`

**Request Body** 

```json
{
    "author": "Kishore",
    "description":"Story of village Boy",
    "title":"Farmer",
    "publisher":"Navneet Publication",
    "price":333,
    "pages": 4000

}
```
-----
## Update Book

**Method:** PUT

**Enpoints:** `http://localhost:9091/api/book/update`

**Request Body**

```json
{
    "author": "Kishore Kumar",
    "description":"Story of village Boy",
    "title":"Farmer",
    "publisher":"Navneet Publication",
    "price":333,
    "pages": 4000,
    "id":4

}
``````
----------
## Gel All Books

**Method:** GET

**Enpoints:**  `http://localhost:9091/api/book/getAll`

----------

## Get Book By Id

**Method:** GET

**Enpoints:**  `http://localhost:9091/api/book/3`

----------
## Delete Book By Id

**Method:** DELETE

**Enpoints:**  `http://localhost:9091/api/book/4`

These are the REST API endpoints and operations available for managing books.

--------

# To run the test cases
### Run the below command to genarate the jacoco report and add below jacoco plugin in pom.xml
**mvn clean jacoco: report**
``````
<!-- JaCoCo Plugin Configuration -->
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.7</version> <!-- Use the latest version available -->
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

``````


