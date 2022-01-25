count = 0;
for i in range(1, 40 + 1):
	nog = i * 5
	n = nog
	if n % 2 == 0:
		n = n - 5
	print("{i} -> {nog} -> {n}".format(i = i, nog = nog, n = n))


print("-------------------------");

for i in range (0, 20):
	n = i * 10 + 5;
	print(n);
