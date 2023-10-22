FROM gradle:jdk17-alpine

WORKDIR /app

COPY . .

RUN addgroup --system myappgroup && adduser --system myappuser -G myappgroup

RUN chown -R myappuser:myappgroup /app

USER myappuser

CMD [ "gradle", "build", "-x", "test" ]