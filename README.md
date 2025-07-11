# 🎯 QR Code Generator – Java + Spring Boot + AWS S3 + Docker

Projeto backend que permite gerar **códigos QR** personalizados a partir de textos enviados via API REST. Os QR Codes são gerados como imagens PNG e armazenados automaticamente em um **bucket AWS S3**. Este projeto visa demonstrar a integração entre **Spring Boot**, a biblioteca **ZXing (Google)**, e a **nuvem AWS**.

---

## 📌 Funcionalidades

- ✅ Geração de QR Codes via API POST
- ✅ Armazenamento das imagens geradas no Amazon S3
- ✅ Resposta com a URL pública do QR Code gerado
- ✅ Execução local ou via Docker
- ✅ Configuração via arquivo `.env`

---

## 🧰 Tecnologias Utilizadas

- Java 21  
- Spring Boot  
- Maven  
- Docker  
- AWS SDK (S3)  
- ZXing (QR Code Generator)  
- REST API

---

## 📦 Pré-requisitos

Antes de executar, certifique-se de ter:

- Java 21 instalado  
- Maven instalado  
- Docker instalado (opcional para execução em container)  
- Conta AWS com bucket S3 configurado  
- AWS CLI com credenciais válidas

---

## ⚙️ Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com os seguintes campos:

```
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=your_region
AWS_BUCKET_NAME=your_bucket_name
```

---

## 🚀 Como Executar

### 🔧 Local (sem Docker)
```
mvn clean package
mvn spring-boot:run
```

### 🐳 Com Docker
```
docker build -t qrcode-generator:1.0 .
docker run --env-file .env -p 8080:8080 qrcode-generator:1.0
```

---

## 📡 Endpoint da API

### `POST /qrcode`

Gera um QR Code a partir do texto enviado e armazena no S3.

**Requisição:**
```json
{
  "text": "https://example.com"
}
```

**Resposta de sucesso:**
```json
{
  "url": "https://your-bucket.s3.your-region.amazonaws.com/uuid.png"
}
```

**Erro:**
```json
{
  "error": "Erro ao gerar QR Code ou salvar no S3"
}
```

---

## 🗂️ Estrutura Geral

- `src/main/java` – código-fonte da aplicação
- `src/main/resources` – configurações da aplicação
- `.env` – variáveis de ambiente (não versionar)
- `Dockerfile` – definição da imagem Docker


