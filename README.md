Perfecto, aquí tienes el `README.md` **completo, bien estructurado y formateado** en Markdown para tu proyecto de pruebas móviles híbridas con Appium, Selenium y BrowserStack:

---

````markdown
# 📱 HybridAppTest

Este proyecto automatiza pruebas funcionales en una **aplicación híbrida desarrollada con Ionic**, usando **Appium + Selenium WebDriver + TestNG**, con ejecución en dispositivos reales mediante **BrowserStack**.

---

## 🚀 Tecnologías Utilizadas

- ✅ **Java 11+**
- ✅ **Appium Java Client v8.3.0**
- ✅ **Selenium WebDriver v4.8.3**
- ✅ **TestNG**
- ✅ **Maven**
- ✅ **BrowserStack**
- ✅ **Ionic + Capacitor (app bajo prueba)**

---

## 📂 Estructura del Proyecto

```bash
HybridAppTest/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── tuempresa/
│       │           ├── base/
│       │           │   └── BaseTest.java           # Setup y teardown (BrowserStack)
│       │           ├── config/
│       │           │   └── ConfigReader.java       # Lectura de config.properties
│       │           ├── helpers/
│       │           │   ├── ClickHelper.java        # Helper para clicks
│       │           │   ├── InputHelper.java        # Helper para escribir texto
│       │           │   └── WaitHelper.java         # Helper para esperas explícitas
│       │           ├── pages/
│       │           │   └── Tab1Page.java           # Page Object de Tab 1
│       │           └── tests/
│       │               └── Tab1Test.java           # Test que verifica Tab 1
│       └── resources/
│           └── config.properties                   # Configuración para BrowserStack
├── pom.xml                                          # Dependencias del proyecto
└── README.md                                        # Esta documentación
````

---

## 🔐 config.properties

Este archivo contiene los datos de conexión a BrowserStack y configuración de dispositivo:

```properties
platformName=Android
deviceName=Google Pixel 7
platformVersion=13.0
app=bs://xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
browserstack.user=usuario_browserstack
browserstack.key=clave_browserstack
project=Hybrid Sample
build=Build 1
name=Test con POM y config
```

---

## ✅ Ejecución del Test

### 1. Asegúrate de tener la app cargada en BrowserStack

Puedes subir el `.apk` o `.ipa` con:

```bash
curl -u "USERNAME:ACCESS_KEY" -X POST "https://api-cloud.browserstack.com/app-automate/upload" \
  -F "file=@/path/to/app.apk"
```

### 2. Ejecuta los tests con Maven

```bash
mvn clean test
```

> Verás un log de conexión exitosa si las capacidades están bien configuradas.

---

## 🧪 BaseTest.java

La clase base crea una sesión remota contra BrowserStack:

```java
@BeforeClass
public void setUp() {
    DesiredCapabilities caps = new DesiredCapabilities();
    // Configuración del dispositivo
    // ...
    driver = new AppiumDriver(new URL("https://usuario:clave@hub.browserstack.com/wd/hub"), caps);
}
```

---

## 💡 Page Object: Tab1Page

```java
public class Tab1Page {
    WebDriver driver;

    public Tab1Page(WebDriver driver) {
        this.driver = driver;
    }

    By titulo = By.xpath("//android.view.View[@text='Tab 1 page']");

    public String obtenerTitulo() {
        return driver.findElement(titulo).getText();
    }
}
```

---

## 🔄 Helpers

### Esperas

```java
public static void waitForVisibility(WebDriver driver, By locator) {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
}
```

### Click

```java
public static void click(WebDriver driver, By locator) {
    waitForVisibility(driver, locator);
    driver.findElement(locator).click();
}
```

### Escribir Texto

```java
public static void write(WebDriver driver, By locator, String text) {
    waitForVisibility(driver, locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
}
```

---

## 🛠 Requisitos Previos

* Java 11 o superior
* Maven instalado
* Cuenta gratuita en [BrowserStack](https://www.browserstack.com/)
* APK o IPA de una app híbrida (Ionic por ejemplo)
* Acceso a dispositivos virtuales con Appium Inspector (opcional)

---

## 🧑‍💻 Autor

Desarrollado por Jefferson Avila

---

## 📄 Licencia

Este proyecto es de uso libre para pruebas, educación o desarrollo. No garantiza cobertura de casos reales sin adaptación a los elementos específicos de la app bajo prueba.


