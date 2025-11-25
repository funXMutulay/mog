@echo on
setlocal
rem Define the startinng directory (current one )
set "startDir=C:\Users\mmduk\OneDrive\Documents\mog\product-photos"

echo Converting jpg to png recursoveluy in "%statDir%"

for /r "%statDir%" %%f in (.jpg) do {
	echo converting to png
	magick "%f" -format png "%%~nf.png"
} 
echo conversion complete
pause