FROM node:18 AS BUILDER

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

FROM nginx

WORKDIR /usr/share/nginx/html

COPY --from=BUILDER /usr/src/app/dist/alticci-ui/* .
