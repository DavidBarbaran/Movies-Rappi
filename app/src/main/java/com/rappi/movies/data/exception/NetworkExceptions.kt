package com.rappi.movies.data.exception

class RequestTimeoutException : Exception("La solicitud tardó demasiado en responder. Intenta nuevamente.")

class UnknownDataException : Exception("La solicitud tardó demasiado en responder. Intenta nuevamente.")

class UncaughtErrorException : Exception("Se produjo un error inesperado, Intenta nuevamente.")