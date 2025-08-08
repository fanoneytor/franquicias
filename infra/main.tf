provider "aws" {
  region = var.aws_region
}

resource "aws_db_instance" "franquicias_db" {
  identifier              = "franquicias-db"
  allocated_storage       = var.db_allocated_storage
  engine                  = "postgres"
  engine_version          = "16.3"
  instance_class          = var.db_instance_class
  db_name                 = var.db_name
  username                = var.db_username
  password                = var.db_password
  parameter_group_name    = "default.postgres16"
  publicly_accessible     = true
  skip_final_snapshot     = true
}

output "db_endpoint" {
  value = aws_db_instance.franquicias_db.address
}
