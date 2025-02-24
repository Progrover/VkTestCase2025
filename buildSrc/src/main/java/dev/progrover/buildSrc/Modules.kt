object Core {
    private const val core = ":core"
    const val base = "$core:base"
    const val theme = "$core:theme"
    const val uicommon = "$core:uicommon"
}

object Feature {
    private const val feature = ":feature"

    object VideoItem {
        private const val videoitem = "$feature:videoitem"
        const val api = "$videoitem:api"
        const val impl = "$videoitem:impl"
    }

    object VideoList {
        private const val videolist = "$feature:videolist"
        const val api = "$videolist:api"
        const val impl = "$videolist:impl"
    }
}