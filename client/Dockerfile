FROM node:current-alpine
WORKDIR /public

COPY package*.json ./
RUN npm install


COPY src .
CMD ["npm", "start"]