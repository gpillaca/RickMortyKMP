package pe.geff.rickmortykmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform