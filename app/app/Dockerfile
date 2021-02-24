FROM node:12.20.1
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
RUN npm install -g @angular/cli
COPY . .
CMD ng serve --host 0.0.0.0



