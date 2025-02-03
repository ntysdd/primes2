use v5.30;
use warnings;

use bigint            qw(lib GMP);
use Math::Prime::Util qw(is_prime);

$| = 1;

for ( my $p = 1 ; $p <= 1000 ; $p++ ) {
    next unless is_prime($p);

    print "$p";

    f($p);
    print "\n";
}

sub f {
    my ($p) = @_;
    my $r = 2;

    my @r;

    while (1) {
        my $n = ( $r**$p - 1 ) / ( $r - 1 );
        if ( is_prime($n) ) {
            push @r, $r;
            print " $r";
            if ( @r == 100 ) {
                return @r;
            }
        }
        $r++;
    }
}
