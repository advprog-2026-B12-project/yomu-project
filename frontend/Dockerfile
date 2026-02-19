# --- Stage 1: Dependencies & Build ---
FROM node:20-alpine AS builder
WORKDIR /app

# Copy package.json dan package-lock.json
COPY package*.json ./

# Install dependencies dengan 'npm ci' (lebih stabil untuk CI/CD daripada npm install)
RUN npm ci

# Copy seluruh kode frontend
COPY . .

# Build Next.js untuk production
RUN npm run build

# --- Stage 2: Runner ---
FROM node:20-alpine AS runner
WORKDIR /app

ENV NODE_ENV production

# Copy file penting dari stage builder
COPY --from=builder /app/package*.json ./
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/public ./public
COPY --from=builder /app/node_modules ./node_modules

# Expose port 3000
EXPOSE 3000

# Jalankan Next.js
CMD ["npm", "start"]