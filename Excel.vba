Public Sub ClearSytles()
    On Error Resume Next
    Dim sty As Style
    For Each sty In ActiveWorkbook.Styles
        sty.Delete
    Next
End Sub
