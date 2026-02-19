# Yomu Project

Repositori ini berisi aplikasi **Yomu** dengan arsitektur Monorepo yang terdiri dari Frontend (Next.js), Backend (Spring Boot), dan Database (PostgreSQL).

---

## Teknologi yang Digunakan

| Komponen          | Teknologi                                      | Versi         |
| ----------------- | ---------------------------------------------- | ------------- |
| **Frontend**      | Next.js (App Router), TypeScript, Tailwind CSS | 16.1.6        |
| **Backend**       | Spring Boot, Java, Spring Data JPA             | 4.02 (JDK 21) |
| **Database**      | PostgreSQL                                     | 15            |
| **Orchestration** | Docker, Docker Compose                         | -             |

---

## Prasyarat Sistem

Sebelum memulai, pastikan perangkat Anda telah terpasang:

- **Docker Desktop** (dengan WSL 2 untuk pengguna Windows)
- **Java JDK 21**
- **Node.js 20 LTS**
- **Git**

---

## Panduan Instalasi Lokal

1. **Kloning Repositori**

```bash
git clone <url-repository-ini>
cd yomu-project
```

2. **Konfigurasi Environment**
   Salin file env example ke file `.env` lokal:

```bash
cp .env.example .env
```

---

## Menjalankan Aplikasi

### Opsi 1: Hybrid Mode (Direkomendasikan untuk Pengembangan)

Gunakan opsi ini untuk proses _debugging_ dan _hot-reloading_ yang lebih cepat.

1. **Jalankan Database**

```bash
docker-compose up -d yomu-db
```

2. **Jalankan Backend (Spring Boot) [Intellij IDEA]**

```bash
cd backend
./gradlew bootRun
```

Server backend tersedia di: `http://localhost:8080`

3. **Jalankan Frontend (Next.js) [VS Code]**
   Buka terminal baru:

```bash
cd frontend
npm install
npm run dev
```

Aplikasi frontend tersedia di: `http://localhost:3000`

### Opsi 2: Full Docker (Simulasi Produksi)

Gunakan perintah ini untuk menjalankan seluruh layanan di dalam container:

```bash
docker-compose up --build
```

---

## Struktur Proyek

```text
yomu-project/
├── backend/            # Aplikasi Spring Boot (Gradle)
├── frontend/           # Aplikasi Next.js (NPM)
├── docker-compose.yml  # Konfigurasi infrastruktur Docker
├── .env.example
└── .gitignore

```

---

## Alur Kerja Git

Untuk menjaga kebersihan riwayat commit, harap ikuti aturan berikut:

- **Branch `main`**: Branch produksi (Protected).
- **Branch `staging`**: Branch integrasi fitur (Protected).
- **Feature Branch**: Gunakan format `feat/nama-fitur` atau `fix/deskripsi-perbaikan`.

> **Catatan Penting:** Selalu lakukan Pull Request (PR) ke branch `staging` sebelum digabungkan ke `main`. Pastikan kode telah di-test secara lokal sebelum melakukan push.
