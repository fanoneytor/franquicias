variable "aws_region" {
  default = "us-east-1"
}

variable "db_name" {
  default = "franquicias"
}

variable "db_username" {
  description = "Usuario de la base de datos"
}

variable "db_password" {
  description = "Contraseña de la base de datos"
  sensitive   = true
}

variable "db_instance_class" {
  default = "db.t3.micro" # free tier
}

variable "db_allocated_storage" {
  default = 20
}
