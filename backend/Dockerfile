# --- Stage 1: Build (Compile Java dengan Gradle) ---
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /app

# Copy file konfigurasi Gradle dulu (untuk caching layer dependencies)
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Beri izin eksekusi ke gradlew (SANGAT PENTING untuk pengguna Windows/WSL)
RUN chmod +x gradlew

# Download dependencies tanpa copy source code (agar docker layer ter-cache)
# Note: '--no-daemon' penting agar build tidak hang di container
RUN ./gradlew dependencies --no-daemon

# Copy source code aplikasi
COPY src src

# Build aplikasi menjadi file JAR (skip test biar cepat)
RUN ./gradlew bootJar -x test --no-daemon

# --- Stage 2: Run (Menjalankan Aplikasi) ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Ambil file .jar dari folder build/libs (Output default Gradle)
# Kita pakai wildcard *.jar agar tidak perlu pusing nama file versinya
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]