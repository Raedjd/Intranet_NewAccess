FROM node:current-alpine
WORKDIR /app/public

COPY package*.json ./
RUN npm install


COPY src .
CMD ["npm", "start"]