Of the two projects in the repo, one is a server project and the other is a client project. The aim of the projects is to create a simple registration method using a zip file client-server relationship.
When you install and run the projects, the postt request on the server is triggered by the appropriate get request sent from the port you created in the client project, and the zip file given as a path is saved to the specified path.


Adım 1: Sunucuyu Başlatma
Öncelikle, hem client hem de server uygulamalarınızı Spring Boot kullanarak başlatmalısınız.

Adım 2: Sunucu Endpoint'ini Test Etme
Server Uygulaması için bir dosya yükleme işlemini test edelim:

Postman'de yeni bir POST isteği oluşturun.
URL olarak http://localhost:8080/upload-zip girin (port numarası ve endpoint projenize göre değişebilir).
Body sekmesine gidin ve form-data seçeneğini seçin.
Key alanına file yazın ve Type alanında File seçeneğini işaretleyin.
Bilgisayarınızdan bir zip dosyası seçin.
Gönder (Send) butonuna tıklayın.
Eğer işlem başarılı olursa, "File uploaded successfully" mesajını içeren bir yanıt alacaksınız.
Adım 3: Client Endpoint'ini Test Etme
Client Uygulaması için dosya gönderme işlemini test edelim:

Postman'de yeni bir GET isteği oluşturun.
URL olarak http://localhost:8081/send-zip girin (port numarası ve endpoint projenize göre değişebilir).
Params sekmesine gidin ve şu parametreleri ekleyin:
filePath: Göndermek istediğiniz zip dosyasının tam yolu (örneğin, C:/path/to/your/file.zip).
url: Sunucu uygulamanızın dosya yükleme endpoint'i (örneğin, http://localhost:8080/upload-zip).
Gönder (Send) butonuna tıklayın.
Eğer işlem başarılı olursa, "File sent successfully!" mesajını içeren bir yanıt alacaksınız. Eğer dosya bulunamazsa, "File not found!" mesajı alırsınız.
Özetle:
Server uygulaması için POST /upload-zip endpoint'ine bir zip dosyası gönderin.
Client uygulaması için GET /send-zip endpoint'ine dosya yolu ve sunucu URL'sini içeren parametrelerle bir GET isteği gönderin.
Postman Konfigürasyon Örneği
Server Uygulaması İçin:
Method: POST
URL: http://localhost:8080/upload-zip
Body:
Type: form-data
Key: file (Type: File)
Value: Bilgisayarınızdaki bir zip dosyasını seçin
Client Uygulaması İçin:
Method: GET
URL: http://localhost:8081/send-zip
Params:
filePath: C:/path/to/your/file.zip
url: http://localhost:8080/upload-zip
Bu adımları izleyerek Postman ile projeyi test edebilirsiniz.
