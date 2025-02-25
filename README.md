# Api-first-example

- Spring Boot : 3.4.2
- Open Api Generator : 7.10.0
- Swagger : 2.8.4
- Jackson-databind-nullable : 0.2.6
- Java : 17

Generar clases e interfaces a partir de una specification OpenApi.

## Estructura 
- En el módulo **api-spec** colocaremos nuestra especificación en la carpeta resources. Esta definición provoca la generación de las clases de la API durante la compilación de Maven
- En el módulo **api-client** colocaremos nuestra especificación en la carpeta resources(Lo suyo sería que estuviese solo en un único módulo). Se generar un cliente para poder consumir la API Rest.
- En nuestro módulo **api-impl**, podemos implementar las interfaces creadas, asegúrese de que el paquete con la especificación se importe en su proyecto y se actualice. En este módulo es donde se implementa toda la API-REST.

**openapi-generator-maven-plugin**

Este plugin se utiliza para generar código a partir de un documento de especificación OpenAPI (anteriormente conocido como Swagger).
Para ello se debe agregar una definición similar a la siguiente en el ___pom.xml___.

**Generación de la especificación de métodos**
```xml
    <build>
        <plugins>
            <plugin> 
                <groupId>org.openapitools</groupId>
                <artifactId>openapi-generator-maven-plugin</artifactId>
                <version>7.7.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <inputSpec>
                                ${project.basedir}/src/main/resources/openapi.yaml
                            </inputSpec>
                            <generatorName>spring</generatorName>
                            <apiPackage>org.generator.api</apiPackage>
                            <modelPackage>org.generator.model</modelPackage>
                            <configOptions>
                                <interfaceOnly>true</interfaceOnly>
                                <useTags>true</useTags>
                                <library>spring-boot</library>
                                <oas3>true</oas3>
                                <useJakartaEe>true</useJakartaEe>
                                <serializableModel>true</serializableModel>
                                <useSpringBoot3>true</useSpringBoot3>
                            </configOptions>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

```

**Generación del cliente**
```xml
 <build>
        <plugins>
            <plugin>
                <groupId>org.openapitools</groupId>
                <artifactId>openapi-generator-maven-plugin</artifactId>
                <version>7.7.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <inputSpec>
                                ${project.basedir}/src/main/resources/openapi.yaml
                            </inputSpec>
                            <generatorName>java</generatorName>
                            <apiPackage>org.generator.api</apiPackage>
                            <modelPackage>org.generator.model</modelPackage>
                            <configOptions>
                                <!--suppress UnresolvedMavenProperty -->
                                <library>resttemplate</library>
                                <oas3>true</oas3>
                                <useJakartaEe>true</useJakartaEe>
                                <serializableModel>true</serializableModel>
                                <useSpringBoot3>true</useSpringBoot3>
                            </configOptions>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```
**Usar un cliente generadoro en otro proyecto**
Añadir la dependencia generada y definir el fichero de configuración para inicializar los objetos correspondientes.

```xml
<dependency>
    <groupId>org.example.api</groupId>
    <artifactId>api-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

```java
@Configuration
public class ApiClientConfig {

    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        //Mover la URL al properties mejor!!!
        apiClient.setBasePath("http://localhost:8080/"); // URL base de la API
        return apiClient;
    }

    @Bean
    public ArtisanControllerApi artisanControllerApi(ApiClient apiClient) {
        return new ArtisanControllerApi(apiClient);
    }
}
```



En general, este bloque de configuración del plugin openapi-generator-maven-plugin se utiliza para personalizar la generación de código a partir de una especificación OpenAPI en un proyecto Maven. 

Puedes ajustar las configuraciones según tus necesidades y requerimientos específicos de tu proyecto, todas las configuraciones del generador se explican con más detalle en el [sitio web de OpenAPI Generator](https://openapi-generator.tech/docs/generators/spring/)

