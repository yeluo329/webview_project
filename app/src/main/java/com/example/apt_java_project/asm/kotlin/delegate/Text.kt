package com.example.apt_java_project.asm.kotlin.delegate

class Text {
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by ::newName
    var newName: Int = 0

}

