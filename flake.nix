{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };
  outputs =
    { nixpkgs, flake-utils, ... }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = import nixpkgs { inherit system; };
      in
      {
        devShells.default = pkgs.mkShell {
          nativeBuildInputs = with pkgs; [ stdenv.cc.cc.lib jdk21 ];
          LD_LIBRARY_PATH = nixpkgs.lib.makeLibraryPath [ pkgs.openal pkgs.glfw pkgs.libGL pkgs.flite ]; 
        };
      }
    );
}
