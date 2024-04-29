## ExchangeRateService

The ExchangeRateService is a temporary implementation to simulate exchange rate updates. Due to issues with the BNB API,
this service generates random exchange rates every 15 seconds and persists them into a PostgreSQL database. The format of
the response is similar to the https://fixer.io/ API. The microservice exposes ```GET /api/exchange-rates``` endpoint, which 
returns exchange rates with Base USD and 20 more currencies in XML format

### Features:
- Generates random exchange rates at regular intervals.
- Persists generated exchange rates into a PostgreSQL database.
- Works on port 8087

### Endpoints:
- GET http://localhost:8087/api/exchange-rates

## ExchangeRateSyncService

The ExchangeRateUpdaterService is responsible for updating exchange rates from the ExchangeRateService and storing them in a PostgreSQL 
database. It exposes a REST endpoint ```GET /api/exchange-rates-sync/download-currencies``` for downloading the latest exchange rates in XML format. 
When exchange rates change, it saves them in the database and sends information about the updates via WebSocket in 
JSON format. The service records exchange rates with both Bulgarian and English names.

### Features:
- Fetches the latest exchange rates from the ExchangeRateService and persists them into cache for 15 seconds.
- Stores exchange rates in a PostgreSQL database.
- Exposes a REST endpoint for downloading currencies.
- Sends updates via WebSocket in JSON format.
- Works on port 8088

### Endpoints:
- GET http://localhost:8088/api/exchange-rates-sync/download-currencies

## ExchangeRateConsumerService

The ExchangeRateConsumerService consumes the exchange rate data sent by the ExchangeRateUpdaterService via WebSocket and
writes it to a PostgreSQL table.

### Features:
- Listens for updates from the ExchangeRateUpdaterService via WebSocket.
- Writes exchange rate data to a PostgreSQL table.
- Works on port 8089
