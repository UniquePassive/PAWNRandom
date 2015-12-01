use strict;
use warnings;
use integer;

my $seed = 0;
sub pawnRandom {
	my $result = 16838 * ($seed & 0xFFFF);
	
	my $temp = 20077 * ($seed & 0xFFFF);
	$temp += 12345;
	$temp = $temp >> 16;
	
	$result += $temp;
		
	$temp = 0;
	{
		no integer;
		$temp = ($seed >> 16);
	}
		$result -= 1043968403 * $temp;

	$result &= 0x7FFFFFFF;
	$seed = 1103515245 * $seed + 12345;
		my $sc = scalar(@_);
	if ($sc) {
		$result %= $_[0];
	}
	return $result;
}

$seed = 124768;

print "Seed: ", $seed, "\n";
print pawnRandom(7), "\n";
print 1 + pawnRandom(12), "\n";
print 1985 + pawnRandom(31), "\n";
print pawnRandom(), "\n";
