build:
	docker build -t test_postgres .

run:
	docker run --name homer_test_postgres --rm -d -p 5432:5432 test_postgres


